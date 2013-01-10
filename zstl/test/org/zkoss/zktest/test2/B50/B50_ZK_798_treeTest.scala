package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B50-ZK-798-tree.zul")
class B50_ZK_798_treeTest extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <h:pre xmlns:h="xhtml">
                      1.Select latest treeitem 
		2.Click the button in the page bottom
		
		The scrollTop shouldn't move to first listitem after click the button.
                    </h:pre>
                    <zscript><![CDATA[
	    import java.util.*;
	    import org.zkoss.zul.*;
	    import org.zkoss.zk.ui.event.*;
	    
		List list = new ArrayList();
		for (int i = 0; i < 200; i++) {
			List list2 = new ArrayList();
			list2.add(new DefaultTreeNode("item " + i,(List) null));
			list.add(new DefaultTreeNode("item " + i,(List)list2) );
		}
		DefaultTreeModel model =  
			new DefaultTreeModel(new DefaultTreeNode(null, list));
		
		TreeitemRenderer render = new TreeitemRenderer() {
			public void render(Treeitem item, Object data,int i) throws Exception {
				Treerow tr;
				if (item.getTreerow() == null) {
					tr = new Treerow();
					tr.setParent(item);
				} else {
					tr = item.getTreerow();
					tr.getChildren().clear();
				}
				tr.appendChild(new Treecell((String) ((DefaultTreeNode) data).getData()));
				item.setValue(data);
				
				item.addEventListener("onOpen",new org.zkoss.zk.ui.event.EventListener(){
					public void onEvent(org.zkoss.zk.ui.event.Event event) throws Exception {
						event.stopPropagation();
					}
				});
			}
		};
	]]></zscript>
                    <tree id="tree" model="${model}" itemRenderer="${render }" pageSize="50">
                      <treecols>
                        <treecol label="col"/>
                      </treecols>
                    </tree>
                    <button label="invalidate" onClick="tree.invalidate();tree.focus();"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        // simulate user scroll action
        jq("body").toElement().set("scrollTop", 4000)
        click(jq(".z-treerow:contains(199)"))
        waitResponse()
        click(jq(".z-button:contains(invalidate)"))
        waitResponse()
        
        verifyNotEquals("The scrollTop shouldn't move to first listitem after click the button.", jq("body").css("scrollTop"), 0)
      })

  }
}
