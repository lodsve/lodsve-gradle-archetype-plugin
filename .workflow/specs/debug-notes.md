---
title: "Debug Notes"
readMode: optional
priority: medium
category: debug
keywords:
  - debug
  - issue
  - workaround
  - root-cause
  - gotcha
---

# Debug Notes

## Entries



<spec-entry category="debug" keywords="" date="2026-09-30" sid="S-20260930-2djo" title="构建版本与命令差异" sourceRef="gradle/wrapper/gradle-wrapper.properties" relatedPaths="gradle/wrapper/gradle-wrapper.properties">

### 构建版本与命令差异

以 Wrapper 固定的 Gradle 5.1.1 为准；build.gradle 使用历史 maven 插件，profile-gradle.gradle 使用 compile 配置，不在初始化时升级 Gradle。README 的 cleanArch 与源码注册名 cleanArchetype 不一致，使用源码中的完整任务名。

证据：`gradle/wrapper/gradle-wrapper.properties`。

</spec-entry>
