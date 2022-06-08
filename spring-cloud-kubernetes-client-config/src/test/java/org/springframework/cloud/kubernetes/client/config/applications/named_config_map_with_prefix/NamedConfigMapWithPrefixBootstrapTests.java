/*
 * Copyright 2013-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.client.config.applications.named_config_map_with_prefix;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ryan Baxter
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = NamedConfigMapWithPrefixApp.class,
		properties = { "spring.cloud.bootstrap.name=named-configmap-with-prefix",
				"named.config.map.with.prefix.stub=true", "spring.main.cloud-platform=KUBERNETES",
				"spring.cloud.bootstrap.enabled=true", "spring.cloud.kubernetes.client.namespace=spring-k8s" })
class NamedConfigMapWithPrefixBootstrapTests extends NamedConfigMapWithPrefixTests {

}
