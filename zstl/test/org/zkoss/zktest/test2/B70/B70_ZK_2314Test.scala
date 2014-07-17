package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2314.zul")
class B70_ZK_2314Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2314.zul

	Purpose:
		
	Description:
		
	History:
		Fri, May 30, 2014  5:47:56 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<zscript>
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;
public class TreeComposer extends GenericForwardComposer {
  Tree treView;
  
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
  
  	public void onClick$btnMakeTree() {
    		treView.appendChild(new Treechildren());

                Treeitem ti1 = new Treeitem();
                ti1.setLabel("1");
        
                ti1.appendChild(new Treechildren());
                Treeitem ti11 = new Treeitem();
                ti11.setLabel("1.1");
                ti1.getTreechildren().appendChild(ti11);
        
                treView.getTreechildren().appendChild(ti1);
        
                for (Treeitem treeItem : treView.getItems()) {
                    treeItem.setSelected(true);
                } 
  
	}
}
</zscript>
  <window  apply="TreeComposer">
    <tree id="treView" checkmark="true" multiple="true">
        <treecols>
            <treecol width="200px" label="Path" />
            <treecol width="350px" label="Description" />
        </treecols>
    </tree>
  <button id="btnMakeTree" label="Click me, it should not cause any JS error!"/>
</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      val btn = jq("$btnMakeTree");
      click(btn);
      waitResponse();
      verifyFalse(jq(".z-error").exists());
    })
    
  }
}