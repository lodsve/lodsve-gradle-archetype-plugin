---
title: "Test Conventions"
readMode: required
priority: high
category: test
keywords:
  - test
  - coverage
  - mock
  - fixture
  - assertion
  - framework
---

# Test Conventions

## Framework

## Directory Structure

## Naming Conventions

## Patterns

## Entries



<spec-entry category="test" keywords="" date="2026-09-30" sid="S-20260930-xai0" title="现有验证能力" sourceRef="src/main/groovy/com/lodsve/gradle/archetype/ArchetypeCleanTask.groovy" relatedPaths="src/main/groovy/com/lodsve/gradle/archetype/ArchetypeCleanTask.groovy">

### 现有验证能力

未发现 src/test 或测试框架依赖。可执行 ./gradlew build 验证构建，但不能将 NO-SOURCE 视为测试通过；模板行为需在隔离临时消费工程验证，避免对已有业务目录执行 cleanArchetype。

证据：`src/main/groovy/com/lodsve/gradle/archetype/ArchetypeCleanTask.groovy`。

</spec-entry>
