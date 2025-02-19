/*
 * Copyright 2014 Click Travel Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.clicktravel.cheddar.request.context;

import java.util.Optional;

/**
 * Default implementation which stores all elements of a security context.
 */
public class DefaultSecurityContext implements SecurityContext {

    private final Optional<String> userId;
    private final Optional<String> teamId;
    private final Optional<String> identityProviderId;
    private final Optional<String> agentUserId;

    private final Optional<String> appId;

    public DefaultSecurityContext(final String userId, final String teamId,
            final String agentUserId, final String appId, final String identityProviderId) {
        this.userId = Optional.ofNullable(userId);
        this.teamId = Optional.ofNullable(teamId);
        this.identityProviderId = Optional.ofNullable(identityProviderId);
        this.agentUserId = Optional.ofNullable(agentUserId);
        this.appId = Optional.ofNullable(appId);
    }

    public DefaultSecurityContext(final String userId, final String teamId, final String agentUserId,
            final String appId) {
        this(userId, teamId, agentUserId, appId, null);
    }

    public DefaultSecurityContext(final String userId, final String teamId) {
        this(userId, teamId, null, null, null);
    }

    public DefaultSecurityContext(final String userId) {
        this(userId, null, null, null, null);
    }

    @Override
    @Deprecated
    public String principal() {
        return userId.orElse(null);
    }

    @Override
    public Optional<String> userId() {
        return userId;
    }

    @Override
    public Optional<String> teamId() {
        return teamId;
    }

    @Override
    public Optional<String> identityProviderId() { return identityProviderId; }

    @Override
    public Optional<String> agentUserId() {
        return agentUserId;
    }

    @Override
    public Optional<String> appId() {
        return appId;
    }
}
