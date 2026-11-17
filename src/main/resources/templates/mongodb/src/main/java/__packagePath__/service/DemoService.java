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
package @packageName@.service;

import @packageName@.domain.Demo;
import @packageName@.repository.DemoRepository;
import com.lodsve.boot.component.mongodb.dynamic.SwitchMongoDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final DemoRepository repository;

    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }

    public Demo save(Demo demo) {
        return repository.save(demo);
    }

    public Demo get(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Demo> list() {
        return repository.findAll();
    }

    @SwitchMongoDataSource("archive")
    public Demo saveToArchive(Demo demo) {
        return repository.save(demo);
    }

    @SwitchMongoDataSource("archive")
    public Demo getFromArchive(String id) {
        return repository.findById(id).orElseThrow();
    }

    @SwitchMongoDataSource("archive")
    public List<Demo> listFromArchive() {
        return repository.findAll();
    }
}
