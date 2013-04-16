package org.zkoss.zktest.test2.Z60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "Touch,Android")
class Z60_Touch_044Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns:n="native">
                    <h:pre xmlns:h="xhtml">
                      iPad/Android only
		1. Click "setModel1" button and select last item in the Listbox.
		2. Click "setModel2" button.
		3. Click "setModel1" button.
		Should see selected item directly and try to scroll inside the Listbox, it should work fine.
                    </h:pre>
                    <zscript><![CDATA[
		java.util.List l1 = new java.util.ArrayList();
		java.util.List l2 = new java.util.ArrayList();
		l2.add("Option ABC");
		for (int i = 1; i <= 20; i++)
			l1.add("Option " + i);
		org.zkoss.zul.ListModelList strset1 = new org.zkoss.zul.ListModelList(l1);
		org.zkoss.zul.ListModelList strset2 = new org.zkoss.zul.ListModelList(l2);
	]]></zscript>
                    <listbox id="abc" height="200px"></listbox>
                    <button label="setModel1" onClick="abc.setModel(strset1)"/>
                    <button label="setModel2" onClick="abc.setModel(strset2)"/>
                    <h:pre xmlns:h="xhtml">
                      1.Select latest treeitem.
		2.Click "invalidate" button.
		Should see the selected treeitem and try to scroll inside the Tree, it should work fine.
                    </h:pre>
                    <zscript><![CDATA[
	    import java.util.*;
	    import org.zkoss.zul.*;
	    import org.zkoss.zk.ui.event.*;
	    
		List list = new ArrayList();
		for (int i = 0; i < 20; i++) {
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
                    <tree id="tree" model="${model}" itemRenderer="${render }" height="300px">
                      <treecols>
                        <treecol label="col"/>
                      </treecols>
                    </tree>
                    <button label="invalidate" onClick="tree.invalidate();tree.focus();"/>
                  </zk>"""

    runZTL(zscript,
      () => {
        val set1 = jq(".z-button:contains(setModel1)")
        singleTap(set1)
        waitResponse()
        val listbody = jq(".z-listbox-body")
        swipeUp(listbody, 500)
        waitResponse(true)
        singleTap(jq(".z-listitem:contains(20)"))
        waitResponse()
        singleTap(jq(".z-button:contains(setModel2)"))
        waitResponse()
        singleTap(set1)
        sleep(3000)

        verifyEquals("Should see selected item directly and try to scroll inside the Listbox,", listbody.css("scrollTop"), 400)
      })

  }
}
