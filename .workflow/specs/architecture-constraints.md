---
title: "Architecture Constraints"
readMode: required
priority: high
category: arch
keywords:
  - architecture
  - module
  - layer
  - boundary
  - dependency
  - structure
---

# Architecture Constraints

## Module Structure

## Layer Boundaries

## Dependency Rules

## Technology Constraints

## Entries



<spec-entry category="arch" keywords="" date="2026-09-30" sid="S-20260930-oa3e" title="插件任务与模板边界" sourceRef="src/main/groovy/com/lodsve/gradle/archetype/ArchetypePlugin.groovy" relatedPaths="src/main/groovy/com/lodsve/gradle/archetype/ArchetypePlugin.groovy">

### 插件任务与模板边界

ArchetypePlugin 注册任务，GenerateTask 解析参数和 binding，CleanTask 清理 generated/，util/FileUtils 执行模板和文件处理，ConsoleUtils 负责交互。保持插件 ID、generate/cleanArchetype 任务名、默认模板路径与变量协议兼容。

证据：`src/main/groovy/com/lodsve/gradle/archetype/ArchetypePlugin.groovy`。

</spec-entry>
