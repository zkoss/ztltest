/* B50_3340841Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Oct 12 13:01:21 CST 2011 , Created by benbai
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
 * A test class for bug 3340841
 * @author benbai
 *
 */
@Tags(tags = "B50-3340841.zul,A,M,Listbox,Tree")
class B50_3340841Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
				The first Listitem/Treeitem should be selected (and the checkmark should be checked).
				<listbox id="listbox" multiple="true" checkmark="true" width="200px"
					sclass="readonly-listbox">
					<listhead>
						<listheader>Population</listheader>
					</listhead>
					<listitem selected="true" disabled="true">
						<listcell>A. Graduate</listcell>
					</listitem>
					<listitem disabled="true">
						<listcell>B. College</listcell>
					</listitem>
				</listbox>
				<tree id="tree" multiple="true" checkmark="true" width="200px">
					<treecols>
						<treecol>Population</treecol>
					</treecols>
					<treechildren>
						<treeitem selected="true" disabled="true">
							<treerow>
								<treecell>A. Graduate</treecell>
							</treerow>
						</treeitem>
						<treeitem disabled="true">
							<treerow>
								<treecell>B. College</treecell>
							</treerow>
						</treeitem>
					</treechildren>
				</tree>
			</zk>

    """
def executor = ()=>{
		verifyTrue(jq(".z-listitem:eq(0)").hasClass("z-listitem-selected"));
		verifyTrue(jq(".z-treerow:eq(0)").hasClass("z-treerow-selected"));
    }
runZTL(zscript, executor);
   
   // Run syntax 2
   /**
    runZTL(zscript,
        () => {
        var l1: Widget = engine.$f("l1");
        var l2: Widget = engine.$f("l2");
        waitResponse();
        var strClickBefor = getText(l1);
        click(l1);
        waitResponse();
        verifyNotEquals(strClickBefor, getText(l1));
        strClickBefor = getText(l2);
        click(l2);
        waitResponse();
        verifyNotEquals(strClickBefor, getText(l2));
    }
   );
    */
    /** create widget example
		var tree: Widget = engine.$f("tree");
		var listbox: Widget = engine.$f("listbox");
		waitResponse();
	*/
   /** trigger mouse event example
    Scripts.triggerMouseEventAt(getWebDriver(), inner1, "click", "5,5");
    */
   /** detect whether exception exists example
   		verifyFalse(jq(".z-window-highlighted").exists());
   		verifyFalse(jq(".z-window-modal").exists())
	*/
	
  }
}