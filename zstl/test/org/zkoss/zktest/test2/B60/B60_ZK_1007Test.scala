/* B60_ZK_1007Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Apr 23 11:55:19 CST 2012 , Created by benbai
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
 * A test class for bug ZK-1007
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-1007.zul,B,H,onInitModel,Tree")
class B60_ZK_1007Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
			<zk>
			<h:pre xmlns:h="html">
				Check Render items:
					if items is 2 that's right  , if items is 4 , that's wrong.
					
			</h:pre>
			<div id="treeDiv" apply="org.zkoss.zktest.test2.B60_ZK_1007_TreeComposer">
			  <label id="lbl" />
			    <tree id="treeGrid" width="550px" treeitemRenderer="@{treeDiv$composer.treeRenderer}" model="@{treeDiv$composer.treeModel}" >
			        <treecols>
			            <treecol width="200px" label="Path" />
			            <treecol width="350px" label="Description" />
			        </treecols>
			    </tree>
			    <label id="result" />
			</div>
			</zk>

    """

    runZTL(zscript,
        () => {
        var lbl: Widget = engine.$f("lbl");

        verifyTrue("Render items should be 2",
            lbl.$n().get("innerHTML").contains("2"));
    }
   );
  }
}