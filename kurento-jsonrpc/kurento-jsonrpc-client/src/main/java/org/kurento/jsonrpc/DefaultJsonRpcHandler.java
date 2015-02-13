/*
 * (C) Copyright 2013 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package org.kurento.jsonrpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DefaultJsonRpcHandler<P> implements JsonRpcHandler<P> {

	private final Logger log = LoggerFactory
			.getLogger(DefaultJsonRpcHandler.class);

	private boolean useSockJs;

	@Override
	public void afterConnectionEstablished(Session session) throws Exception {
	}

	@Override
	public void afterConnectionClosed(Session session, String status)
			throws Exception {
	}

	@Override
	public void handleTransportError(Session session, Throwable exception)
			throws Exception {
		log.warn("Transport error", exception);
	}

	@Override
	public void handleUncaughtException(Session session, Exception exception) {
		log.warn("Uncaught exception in handler {}", this.getClass().getName(),
				exception);
	}

	@Override
	public Class<?> getHandlerType() {
		return this.getClass();
	}

	@Override
	public void withSockJS() {
		this.useSockJs = true;
	}

	@Override
	public boolean isSockJSEnabled() {
		return this.useSockJs;
	}

}
