/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.hadoop.ozone.container.keyvalue;

import org.apache.hadoop.hdds.annotation.InterfaceAudience;
import org.apache.hadoop.metrics2.MetricsCollector;
import org.apache.hadoop.metrics2.MetricsSystem;
import org.apache.hadoop.metrics2.annotation.Metrics;
import org.apache.hadoop.metrics2.lib.DefaultMetricsSystem;
import org.apache.hadoop.metrics2.lib.MetricsRegistry;
import org.apache.hadoop.ozone.OzoneConsts;
import org.apache.hadoop.ozone.lock.AbstractLockMetrics;

/**
 * Metrics for the KeyValueContainer Lock.
 */
@InterfaceAudience.Private
@Metrics(about = "KeyValueContainer Lock Metrics", context = OzoneConsts.OZONE)
public final class KeyValueContainerLockMetrics extends AbstractLockMetrics {
  private static final String SOURCE_NAME = KeyValueContainerLockMetrics.class.getSimpleName();

  private KeyValueContainerLockMetrics() {
    super(new MetricsRegistry(SOURCE_NAME));
  }

  public static KeyValueContainerLockMetrics create() {
    MetricsSystem ms = DefaultMetricsSystem.instance();
    return ms.register(SOURCE_NAME, "KeyValueContainer Lock Metrics",
        new KeyValueContainerLockMetrics());
  }

  public void unRegister() {
    MetricsSystem ms = DefaultMetricsSystem.instance();
    ms.unregisterSource(SOURCE_NAME);
  }

  @Override
  public void getMetrics(MetricsCollector collector, boolean all) {
    super.getMetrics(collector, all, SOURCE_NAME);
  }
}
