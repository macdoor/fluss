/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.fluss.exception;

import org.apache.fluss.annotation.PublicEvolving;

/**
 * Thrown when incomplete write batches are aborted because the writer was force closed (e.g. the
 * client was closed with a zero timeout, or closed re-entrantly from a write callback).
 *
 * <p>This is an expected consequence of an explicit close, not a write failure: records that were
 * not yet persisted will be replayed by the producer from its last checkpoint. Callers that close a
 * writer intentionally (such as sink writers on task cancellation) can use this type to distinguish
 * the force-close abort from genuine send failures and avoid escalating it to a fatal error.
 *
 * @since 1.1
 */
@PublicEvolving
public class WriterForceClosedException extends FlussRuntimeException {

    private static final long serialVersionUID = 1L;

    public WriterForceClosedException(String message) {
        super(message);
    }
}
