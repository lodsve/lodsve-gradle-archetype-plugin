/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package @packageName@.web;

import @packageName@.domain.Demo;
import @packageName@.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Demo save(@RequestBody Demo demo) {
        return service.save(demo);
    }

    @GetMapping("/{id}")
    public Demo get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping
    public List<Demo> list() {
        return service.list();
    }

    @PostMapping("/archive/save")
    public Demo saveToArchive(@RequestBody Demo demo) {
        return service.saveToArchive(demo);
    }

    @GetMapping("/archive/{id}")
    public Demo getFromArchive(@PathVariable String id) {
        return service.getFromArchive(id);
    }

    @GetMapping("/archive/list")
    public List<Demo> listFromArchive() {
        return service.listFromArchive();
    }
}
