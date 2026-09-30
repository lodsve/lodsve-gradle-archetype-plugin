# Project: lodsve-gradle-archetype-plugin

## What This Is

基于本地模板生成项目的 Gradle 插件，支持交互式和批处理参数。

## Core Value

通过可配置的模板和变量生成一致的项目骨架。

## Requirements

### Validated

以下能力由现有源码/配置确认，不代表本次完成运行时测试或用户价值验证。

- [x] 以 com.lodsve.archetype 插件注册 generate 和 cleanArchetype 任务。 证据：`src/main/groovy/com/lodsve/gradle/archetype/ArchetypePlugin.groovy`。
- [x] 支持交互式参数、系统属性、额外 binding 与 bindingProcessor。 证据：`src/main/groovy/com/lodsve/gradle/archetype/ArchetypeGenerateTask.groovy`。
- [x] 从模板生成文件并支持 .nontemplates 复制与目标文件冲突检查。 证据：`src/main/groovy/com/lodsve/gradle/archetype/util/FileUtils.groovy`。

### Active

本次范围为既有项目接入 Maestro；尚未指定新增产品需求。

### Out of Scope

- 本次不升级技术栈、不改变公开接口、不调整现有源码目录。

## Context

项目属于 lodsve 工作区；各子项目独立维护工作流与知识。

## Constraints

- 保持现有行为和向后兼容。
- 基于各项目现有构建工具和代码约定工作。

## Tech Stack

Groovy；Gradle Wrapper 5.1.1；sourceCompatibility 为 Java 8；Gradle API 与 localGroovy；版本 1.0.1-RELEASE。发布脚本按 profile 选择 maven 或 gradle，默认 maven。

## Key Decisions

| # | Decision | Choice | Source (user / code / default) | Confidence (high / medium / LOW) |
|---|----------|--------|--------------------------------|---------------------------------|
| 1 | 初始化范围 | 5 个子项目独立初始化，各用根目录 .workflow/ | user | high |
| 2 | 项目类型 | 既有项目接入 | code | high |
| 3 | 技术栈与目录 | 沿用当前构建配置与源码布局 | code | high |
| 4 | 代码索引 | 初始化时建立 Maestro 代码知识图谱 | user | high |
| 5 | 工作流偏好 | 研究、复盘、工作流文档提交、执行后代码库文档同步开启；仅已有 Git 仓库提交 | user | high |
| 6 | 本次目标 | 仅接入工作流；未指定后续产品目标，不预设路线图 | default | LOW |
| 7 | 规范与词表 | 根据源码填充规范；自动发现无术语候选，词表保持空列表 | code | high |

## Stakeholders

- 项目维护者与 Lodsve 使用者。

## Initialization Notes

- W001：4 个并行研究代理各重试一次仍返回 502/503，汇总代理也失败，未形成代理研究报告。保留研究开关，后续阶段可重试；本次规范来自直接源码扫描，不宣称完成了并行研究。
- 当前索引器未提取 Groovy 源码符号；代码图主要覆盖可识别配置文件，插件实现仍需直接检索。
- 索引重建命令：`maestro kg index --include-tests`；过滤规则保存在项目根目录 `.maestroignore`。
- 已执行 `maestro spec init`、`maestro domain init`、`maestro domain discover`；无自动发现的术语候选。
- 本次验证配置、知识条目与索引完整性；没有执行项目构建或业务测试。

---
*Last updated: 2026-09-30 after initialization*
