/* B50_ZK_897Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Mar 12 14:28:20 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

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
 * A test class for bug ZK-897
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-897.zul,A,H,Grid,Listbox,GroupModel")
class B50_ZK_897Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div width="100%" apply="org.zkoss.zktest.test2.B50_ZK_897">
				    <custom-attributes org.zkoss.zul.grid.rod="false"/>
					<grid id="grid"/>
					<custom-attributes org.zkoss.zul.lsitbox.rod="false"/>
					<listbox id="listbox"/>
					<button id="button" label="Run"/>
				</div>
			
			</zk>

    }


   runZTL(zscript, () => {
			var button: Widget = engine.$f("button");

			def checkContents () {
			  verifyTrue("all contents are fine",
			    jq(".z-row:contains(test0)").length() == 2
			    && jq(".z-row:contains(test1)").length() == 2
			    && jq(".z-listcell:contains(test0)").length() == 2
			    && jq(".z-listcell:contains(test1)").length() == 2
			    && jq(".z-group:contains(HEAD)").length() == 2
			    && jq(".z-groupfoot:contains(FOOT)").length() == 2
			    && jq(".z-listgroup:contains(HEAD)").length() == 2
			    && jq(".z-listgroupfoot:contains(FOOT)").length() == 2);
			}
			checkContents();
			click(button);
			waitResponse();
			verifyFalse("should no exception",
			    jq(".z-window-modal").exists());
			checkContents();
		})
  }
}