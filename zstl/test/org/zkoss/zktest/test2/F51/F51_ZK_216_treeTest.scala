/* F51_ZK_216_treeTest.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 17:24:37 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

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
 * A test class for bug ZK-216-tree
 * @author benbai
 *
 */
@Tags(tags = "F51-ZK-216-tree.zul,F60,A,E,template,tree")
class F51_ZK_216_treeTest extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
			<zk>
				<html><![CDATA[
				<ul><li>Please try to open and close the tree node in the following two trees.
				Their behavior shall be exactly the same.</li>
				</ul>
				]]></html>
			
				<menupopup id="menupopup">
			        <menuitem label="Undo"/>
			        <menuitem label="Redo"/>
			        <menu label="Sort">
						<menupopup>
					        <menuitem label="Sort by Name" autocheck="true"/>
					        <menuitem label="Sort by Date" autocheck="true"/>
						</menupopup>
			        </menu>
				</menupopup>
				<zscript><![CDATA[
					import org.zkoss.zul.*;
					public class FileInfo {
					    public String path;
					    public String description;
					    public FileInfo(String path, String description) {
					   	    this.path = path;
					   	    this.description = description;
					    }
					    public String getPath() {
					    	return path;
					    }
					    public String getDescription() {
					    	return description;
					    }	
					}
					
					import org.zkoss.util.CollectionsX;
					
					TreeModel model = new DefaultTreeModel(
					  new DefaultTreeNode(null,
					    new DefaultTreeNode[] {
					      new DefaultTreeNode(new FileInfo("/doc", "Release and License Notes")),
					      new DefaultTreeNode(new FileInfo("/dist", "Distribution"),
					        new DefaultTreeNode[] {
					          new DefaultTreeNode(new FileInfo("/lib", "ZK Libraries"),
					            new DefaultTreeNode[] {
					              new DefaultTreeNode(new FileInfo("zcommon.jar", "ZK Common Library")),
					              new DefaultTreeNode(new FileInfo("zk.jar", "ZK Core Library"))
					            }),
					          new DefaultTreeNode(new FileInfo("/src", "Source Code")),
					          new DefaultTreeNode(new FileInfo("/xsd", "XSD Files"))
					        })
					      }
					  ));
					int index = 0;
				]]></zscript>
				<tree id="trOne" model="${model}">
					<template name="model">
						<treeitem context="menupopup">
							<treerow>
								<treecell label="${each.data.path}"/>
								<treecell label="${each.data.description}"/>
							</treerow>
						</treeitem>
					</template>
				    <treecols>
				        <treecol label="Path"/>
				        <treecol label="Description"/>
				    </treecols>
				</tree>
				<!-- Based on TreeitemRenderer -->
				<zscript><![CDATA[
					public class FiledInfoRenderer implements TreeitemRenderer {
						public void render(Treeitem item, Object data, int index) throws Exception {
							FileInfo fi = (FileInfo) ((DefaultTreeNode)data).getData();
							Treerow tr;
							if (item.getTreerow()==null) {
								tr = new Treerow();
								tr.setParent(item);
							} else {
								tr = item.getTreerow();
								tr.getChildren().clear();
							}
							tr.appendChild(new Treecell(fi.path));
							tr.appendChild(new Treecell(fi.description));
							item.setValue(data);
							item.setContext(menupopup);
						}
					}
					TreeitemRenderer render = new FiledInfoRenderer();
				]]></zscript>
				<tree id="trTwo" model="${model}" itemRenderer="${render}">
				    <treecols>
				        <treecol label="Path"/>
				        <treecol label="Description"/>
				    </treecols>
				</tree>
			</zk>

    """

   runZTL(zscript,
        () => {
        var trOne: Widget = engine.$f("trOne");
        var trTwo: Widget = engine.$f("trTwo");

        def clickAndVerify(node: String, child: String, actor: Widget, checker: Widget, toOpen: Boolean) {
          var $nodeOne = jq(actor.$n("body")).find(".z-treerow:contains("+node+")");
          var $nodeTwo = jq(checker.$n("body")).find(".z-treerow:contains("+node+")");
          var $childOne: JQuery = null;
          var $childTwo: JQuery = null;
          var status: String = "";
          if (toOpen)
            status = "opened";
          else
            status = "closed";

          click($nodeOne.toWidget().$n("open"));
          waitResponse();

          // check only
          verifyTrue("Act icon should exists",  $nodeOne.toWidget().$n("open").exists());
          verifyTrue("Act icon should exists",  $nodeTwo.toWidget().$n("open").exists());

          $childOne = jq(actor.$n("body")).find(".z-treerow:contains("+child+")");
          $childTwo = jq(checker.$n("body")).find(".z-treerow:contains("+child+")");

          verifyTrue("Should "+status,
              $childOne.exists() && $childTwo.exists()
              && (($childOne.offsetTop() - $nodeOne.offsetTop) == ($childTwo.offsetTop() - $nodeTwo.offsetTop)
                  || ($childOne.offsetTop() == 0) && $childTwo.offsetTop() == 0));
        }
        
        clickAndVerify("/dist", "/src", trOne, trTwo, true);
        clickAndVerify("/lib", "zk.jar", trTwo, trOne, true);
        clickAndVerify("/lib", "zk.jar", trOne, trTwo, false);
        clickAndVerify("/dist", "/src", trTwo, trOne, false);
    }
   );
  }
}