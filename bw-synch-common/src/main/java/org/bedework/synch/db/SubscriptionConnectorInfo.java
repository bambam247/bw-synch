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
package org.bedework.synch.db;

import org.bedework.synch.exception.SynchException;
import org.bedework.synch.filters.DefaultFilter;
import org.bedework.synch.filters.Filter;
import org.bedework.synch.filters.XCategoryFilter;
import org.bedework.synch.filters.XlocXContactFilter;
import org.bedework.util.misc.ToString;

import java.util.ArrayList;
import java.util.List;

/** Serializable form of information for a connection to a system via a
 * connector - a connector id and the serialized properties.
 *
 * @author douglm
 */
public class SubscriptionConnectorInfo extends SerializableProperties<SubscriptionConnectorInfo> {
  private String connectorId;

  /**
   * @param val id
   */
  public void setConnectorId(final String val) {
    connectorId = val;
  }

  /**
   * @param sub the subscription
   * @return Ordered list of filters
   * @throws SynchException
   */
  public List<Filter> getInputFilters(final Subscription sub) throws SynchException {
    // TODO - build list from properties
    final List<Filter> filters = new ArrayList<>();

    Filter f = new DefaultFilter();
    f.init(sub);

    filters.add(f);

    if (sub.getInfo().getXlocXcontact()) {
      f = new XlocXContactFilter();
      f.init(sub);

      filters.add(f);
    }

    if (sub.getInfo().getXlocXcategories()) {
      f = new XCategoryFilter();
      f.init(sub);

      filters.add(f);
    }

    return filters;
  }

  /**
   * @param sub the subscription
   * @return Ordered list of filters
   * @throws SynchException
   */
  public List<Filter> getOutputFilters(final Subscription sub) throws SynchException {
    // TODO - build list from properties
    final List<Filter> filters = new ArrayList<>();

    Filter f = new DefaultFilter();
    f.init(sub);

    filters.add(f);

    if (sub.getInfo().getXlocXcontact()) {
      f = new XlocXContactFilter();
      f.init(sub);

      filters.add(f);
    }

    if (sub.getInfo().getXlocXcategories()) {
      f = new XCategoryFilter();
      f.init(sub);

      filters.add(f);
    }

    return filters;
  }

  /**
   * @return id
   */
  public String getConnectorId() {
    return connectorId;
  }

  /* ====================================================================
   *                   Convenience methods
   * ==================================================================== */

  /* ====================================================================
   *                   Object methods
   * ==================================================================== */

  @Override
  public int hashCode() {
    try {
      return getConnectorId().hashCode() * super.hashCode();
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  @Override
  public int compareTo(final SubscriptionConnectorInfo that) {
    if (this == that) {
      return 0;
    }

    try {
      final int res = getConnectorId().compareTo(that.getConnectorId());
      if (res != 0) {
        return res;
      }

      return super.compareTo(that);
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  @Override
  public String toString() {
    try {
      final ToString ts = new ToString(this);

      ts.append("connectorId", getConnectorId());

      super.toStringSegment(ts);

      return ts.toString();
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

}
