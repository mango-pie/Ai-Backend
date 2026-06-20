# 部署指南（后端）

仓库：[mango-pie/Ai-Backend](https://github.com/mango-pie/Ai-Backend)

前端静态资源仓库：[mango-pie/Ai](https://github.com/mango-pie/Ai)

## 环境要求

- JDK 17+
- MySQL 8（库名 `aiscene`）
- Redis 6+（可选；不可用时自动降级为内存 Session）

## 本地开发

```bash
cp src/main/resources/application-local.yml.example src/main/resources/application-local.yml
# 编辑 application-local.yml 填入 API Key 与数据库密码
mvn spring-boot:run
```

`application-local.yml` 已被 git 忽略，不会提交到 GitHub。

## 构建

```bash
mvn clean package -DskipTests
# 产物：target/AI-0.0.1-SNAPSHOT.jar
```

GitHub Actions 在推送 `main` 后会自动构建并上传 JAR（Artifacts，保留 30 天）。

## 数据库初始化

```sql
CREATE DATABASE aiscene CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

依次导入 `src/main/resources/sql/` 下的脚本：

- `chat_conversation_schema.sql`
- `diary_schema.sql`
- `study_schema.sql`
- `tts_schema.sql`

用户、应用等核心表若本地已有，可从开发库导出结构后导入。

## 生产部署（2GB 服务器示例）

### 1. 上传 JAR

```bash
scp target/AI-0.0.1-SNAPSHOT.jar user@server:/opt/ai-backend/
```

### 2. 创建目录

```bash
sudo mkdir -p /app/uploads /app/tts-ref \
  /opt/ai-backend/tmp/code_output /opt/ai-backend/tmp/code_deploy
sudo chown -R appuser:appuser /app/uploads /opt/ai-backend
```

### 3. 环境变量（/etc/ai-backend.env）

```bash
DB_HOST=127.0.0.1
DB_PORT=3306
DB_USER=aiscene
DB_PASSWORD=your-db-password

REDIS_HOST=127.0.0.1
REDIS_PORT=6379

DASHSCOPE_API_KEY=sk-xxx
CODEGEN_API_KEY=sk-xxx
CODEGEN_API_BASE_URL=https://dashscope.aliyuncs.com/compatible-mode/v1
ASTRBOT_BASE_URL=http://your-astrbot:6185
ASTRBOT_API_KEY=abk-xxx

APP_DEPLOY_HOST=https://your-domain.com
UPLOAD_BASE_URL=https://your-domain.com/api
```

### 4. systemd 服务

```ini
[Unit]
Description=AI Backend
After=network.target mysql.service

[Service]
User=appuser
WorkingDirectory=/opt/ai-backend
EnvironmentFile=/etc/ai-backend.env
ExecStart=/usr/bin/java -Xms256m -Xmx512m -jar /opt/ai-backend/AI-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
Restart=on-failure

[Install]
WantedBy=multi-user.target
```

```bash
sudo systemctl daemon-reload
sudo systemctl enable ai-backend
sudo systemctl start ai-backend
```

### 5. Nginx 与前端

- 前端 `dist/` 见前端仓库 `DEPLOY.md`
- 反代 `/api/` → `127.0.0.1:8123`
- AI 生成小站点：`/{deployKey}/` → `/opt/ai-backend/tmp/code_deploy/{deployKey}/`

## 配置说明

| 文件 | 用途 |
|------|------|
| `application.yml` | 默认配置，敏感项用环境变量 |
| `application-local.yml` | 本地密钥（git 忽略） |
| `application-prod.yml` | 生产路径与 `--spring.profiles.active=prod` |

## 端口

- 应用：`8123`，context-path `/api`
- 完整 API 根路径：`http://host:8123/api`

生产环境建议仅通过 Nginx 暴露 80/443，8123 不对公网开放。
