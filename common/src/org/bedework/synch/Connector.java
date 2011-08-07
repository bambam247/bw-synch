/* ********************************************************************
    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.
*/
package org.bedework.synch;

import java.util.Properties;

/** The interface implemented by connectors. This represents the kind of object
 * used to communicate with a particular system or entity. We may implement
 * connectors for files, for exchange for bedework etc.
 *
 * <p>The connector instance carries out global initialisation and provides
 * ConncetorInstance objects per subscription.
 *
 * @author Mike Douglass
 */
public interface Connector<S extends BaseSubscription,
                           C extends ConnectorInstance<S>> {
  /** Start the connector. A response of null means no synch available.
   *
   * <p>The callback url is unique to the connector. It will be used as a path
   * prefix to allow the callback service to locate the handler for incoming
   * callback requests.
   *
   * <p>For example, if the callback context is /synchcb/ and the connector id
   * is "bedework" then the callback uri might be /synchcb/bedework/. The
   * connector might append a uid to that path to allow it to locate the
   * active subscription for which the callback is intended.
   *
   * @param props
   * @param callbackUri
   * @throws SynchException
   */
  void start(Properties props,
             String callbackUri) throws SynchException;

  /** Called to obtain a connector instance for a subscription.
   * A response of null means no synch available.
   *
   * <p>The return value is a random uid which is used to validate incoming
   * callback requests from the remote server.
   *
   * @param token - null for new connection - current token for ping
   * @return null for no synch else a random uid.
   * @throws SynchException
   */
  C getConnectorInstance(S sub) throws SynchException;

  void stop() throws SynchException;
}