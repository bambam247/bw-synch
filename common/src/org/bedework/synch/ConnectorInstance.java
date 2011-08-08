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

import org.oasis_open.docs.ns.wscal.calws_soap.AddItemResponseType;
import org.oasis_open.docs.ns.wscal.calws_soap.FetchItemResponseType;
import org.oasis_open.docs.ns.wscal.calws_soap.UpdateItemResponseType;
import org.oasis_open.docs.ns.wscal.calws_soap.UpdateItemType;

import ietf.params.xml.ns.icalendar_2.IcalendarType;

import java.util.List;

/** The interface implemented by connectors.
 *
 * @author Mike Douglass
 */
public interface ConnectorInstance<S extends BaseSubscription> {
  /** Information used to synch remote with Exchange
   * This information is only valid in the context of a given subscription.
   */
  public static class ItemInfo {
    /** */
    public String uid;

    /** */
    public String lastMod;

    /** */
    public boolean seen;

    /**
     * @param uid
     * @param lastMod
     */
    public ItemInfo(final String uid,
                     final String lastMod) {
      this.uid = uid;
      this.lastMod = lastMod;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("ItemInfo{");

      sb.append("uid=");
      sb.append(uid);

      sb.append(",\n   lastMod=");
      sb.append(lastMod);

      sb.append("}");

      return sb.toString();
    }
  }

  /** Get information about items in the subscribed calendar. Used for initial
   * synch.
   *
   * @return List of items - never null, maybe empty.
   * @throws SynchException
   */
  List<ItemInfo> getItemsInfo() throws SynchException;

  /** Add a calendar component
   *
   * @param val
   * @return response
   * @throws SynchException
   */
  AddItemResponseType addItem(IcalendarType val) throws SynchException;

  /** Fetch a calendar component
   *
   * @param uid of item
   * @return response
   * @throws SynchException
   */
  FetchItemResponseType fetchItem(String uid) throws SynchException;

  /** Update a calendar component
   *
   * @param uid of item
   * @param updates
   * @return response
   * @throws SynchException
   */
  UpdateItemResponseType updateItem(String uid,
                                    UpdateItemType updates) throws SynchException;
}
