/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.testcase.servicecomb.provider;

import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;
import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.apache.skywalking.apm.testcase.servicecomb.schema.Hello;
import org.apache.skywalking.apm.testcase.servicecomb.schema.models.Person;

@RpcSchema(schemaId = "codeFirstHello")
public class CodeFirstPojoHelloProviderImpl implements Hello {
    private static Logger LOGGER = Logger.getLogger(CodeFirstPojoHelloProviderImpl.class);

    @Override
    public String sayHi(String name) {
        return "Pojo Hello " + name;
    }

    @Override
    public CompletableFuture<String> sayHi_asyn(Person person) {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("Pojo Hello person " + person.getName());
        return future;
    }
}
