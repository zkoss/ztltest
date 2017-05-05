/* B50_ZK_564Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Dec 05 12:14:41 CST 2011 , Created by benbai
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
 * A test class for bug ZK-564
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-564.zul,B,E,Tree,DefaultTreeNode,Serializable,Clone,VisionTest")
class B50_ZK_564Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<zk>
			<vbox id="vb" apply="org.zkoss.zktest.test2.B50_ZK_564_Composer">
				<div>1. click the "Add" to add the tree nodes. </div>
				<div>2. click the "Clone by Serialization" to copy another Tree.</div>
				<div>3. You should see a copied tree is the same as the origin one and no error dialog appears.</div>
				<div>
					<button label="Add" id="add"/>
				</div>
				<tree id="tree" />
				
				<button label="Clone by Serialization" id="clone">
					<attribute name="onClick"><![CDATA[{
				import java.io.*;
				ByteArrayOutputStream boa = new ByteArrayOutputStream();
				new ObjectOutputStream(boa).writeObject(tree);
				byte[] bs = boa.toByteArray();
				Object l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
				l.setId("tree" + vb.getChildren().size());
				vb.insertBefore(l, self);
				vb.insertBefore(new Label(bs.length+" bytes copied"), self);
					}]]></attribute>
				</button>
				</vbox>
			</zk>

    """
runZTL(zscript, () => {
   			var add: Widget = engine.$f("add");
   			var clone: Widget = engine.$f("clone");

   			def clickAndWait = (target: org.zkoss.ztl.ClientWidget) => {
				click(target);
				waitResponse();
			}
   			clickAndWait(add);
   			clickAndWait(jq(".z-messagebox-window .z-button"));
   			clickAndWait(clone);

   			verifyTrue("NotSerializableException suohld not occur",
   			    jq("div:contains(java.io.NotSerializableException)").length() == 0);

		})
  }
}