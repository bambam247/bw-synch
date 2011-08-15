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

import java.io.Serializable;
import java.util.Map;

/** This class defines the various properties we need for the synch engine
 *
 * @author Mike Douglass
 */
public class SynchConfig implements Serializable {
  /* web service push callback uri - null for no service */
  private String callbackURI;

  /* Path to keystore - null for use default */
  private String keystore;

  private Map<String, String> connectors;

  /** web service push callback uri - null for no service
   *
   * @param val    String
   */
  public void setCallbackURI(final String val) {
    callbackURI = val;
  }

  /** web service push callback uri - null for no service
   *
   * @return String
   */
  public String getCallbackURI() {
    return callbackURI;
  }

  /** Path to keystore - null for use default
   *
   * @param val    String
   */
  public void setKeystore(final String val) {
    keystore = val;
  }

  /** Path to keystore - null for use default
   *
   * @return String
   */
  public String getKeystore() {
    return keystore;
  }

  /** Map of (name, className)
   *
   * @param val
   */
  public void setConnectors(final Map<String, String> val) {
    connectors = val;
  }

  /** Map of (name, className)
   *
   * @return map
   */
  public Map<String, String> getConnectors() {
    return connectors;
  }
}