/* B60_ZK_725Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Feb 17 10:49:30 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

/**
 * A test class for bug ZK-725
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-725.zul,A,E,sort")
class B60_ZK_725Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
			<html><![CDATA[
			Click the header (Author) to sort the grid. It is OK if it is sorted correctly.
			]]></html>
			
			<grid id="grid">
				<columns>
					<column label="Author" sort="auto" />
				</columns>
				<rows>
					<row>
						<label value="BRow" />
					</row>
					<row>
						<label value="CRow" />
					</row>
					<row>
						<label value="ARow" />
					</row>
				</rows>
			</grid>
			</zk>

    """
runZTL(zscript,
        () => {
        var grid: Widget = engine.$f("grid");
        
        click (jq(".z-column:contains(Author)").get(0));
        waitResponse();
        
        verifyTrue("should sorted correctly",
            jq(".z-row:contains(ARow)").get(0).get("id").equals(jq(".z-row").get(0).get("id")));
        verifyTrue("should sorted correctly",
            jq(".z-row:contains(BRow)").get(0).get("id").equals(jq(".z-row").get(1).get("id")));
        verifyTrue("should sorted correctly",
            jq(".z-row:contains(CRow)").get(0).get("id").equals(jq(".z-row").get(2).get("id")));
    }
   );
  }
}