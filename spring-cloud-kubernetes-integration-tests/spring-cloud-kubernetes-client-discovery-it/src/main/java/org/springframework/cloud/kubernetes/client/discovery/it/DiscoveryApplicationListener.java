/*
 * Copyright 2013-2023 the original author or authors.
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

package org.springframework.cloud.kubernetes.client.discovery.it;

import io.kubernetes.client.openapi.models.V1Pod;
import org.apache.commons.logging.LogFactory;

import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.log.LogAccessor;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.kubernetes.commons.discovery.KubernetesDiscoveryClientHealthIndicatorInitializer.RegisteredEventSource;

/**
 * @author wind57
 */
@Component
public class DiscoveryApplicationListener implements ApplicationListener<InstanceRegisteredEvent<?>> {

	private static final LogAccessor LOG = new LogAccessor(LogFactory.getLog(DiscoveryApplicationListener.class));

	@Override
	public void onApplicationEvent(InstanceRegisteredEvent<?> event) {
		V1Pod pod = (V1Pod) ((RegisteredEventSource) event.getSource()).pod();
		LOG.info(() -> "received InstanceRegisteredEvent from pod with 'app' label value : "
				+ pod.getMetadata().getLabels().get("app"));
	}

}
