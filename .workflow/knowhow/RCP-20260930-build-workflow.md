---
title: lodsve-gradle-archetype-plugin — 构建 Gradle 插件
type: recipe
explicitId: rcp-20260930-build-workflow
created: 2026-09-30T15:42:17.795Z
keywords:
  - workflow
  - build-workflow
  - auto-generated
sourceRef: build.gradle
lifecycleStatus: active
relatedPaths:
  - build.gradle
---

## Goal

构建 Gradle 插件。

## Prerequisites

使用适配当前 Gradle Wrapper 的 JDK；sourceCompatibility 配置为 Java 8。

## Steps

在项目根目录执行：

```sh
./gradlew build
```

## Expected Outcome

Gradle 完成插件编译与打包，产物位于 build/。

## Common Pitfalls

默认 profile=maven；本次未执行构建或确认本地 JDK 与旧 Wrapper 的兼容性。没有现成测试集，build 成功不代表模板行为已覆盖。

## Related

- `build.gradle`
- [[architecture-constraints]]
