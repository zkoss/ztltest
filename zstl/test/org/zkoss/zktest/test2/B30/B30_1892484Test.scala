/* B30_1892484Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 1892484
 * @author ldnigro
 *
 */
@Tags(tags = "B30-1892484.zul,A,E,Tree,Serialize,BI")
class B30_1892484Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
    	<window title="Serialize Live Data" border="normal">
    	<zscript><![CDATA[
    		import java.io.*;
    		import org.zkoss.zktest.test2.tree.TreeModelA;

    		int cnt = 0;
    		Object l;
	
    		void serialize(Component from) {
    			ByteArrayOutputStream boa = new ByteArrayOutputStream();
    			new ObjectOutputStream(boa).writeObject(from);
    			byte[] bs = boa.toByteArray();
    			l = new ObjectInputStream(new ByteArrayInputStream(bs)).readObject();
    			l.setId("dst" + ++cnt);
    			l.setParent(vb);
    			new Label(bs.length+" bytes copied").setParent(vb);
    		}
	
    		//An ArrayList is created to be the root of tree
    		ArrayList mother = new ArrayList();
		
    		//Assign children to root "mother"
    		mother.add("Andy");
    		mother.add("Davis");
    		mother.add("Matter");
    		mother.add("Kitty");
		
    		//TreeModelA class is contructed, only the root "mother" of tree is passed to its constructor.
    		TreeModelA tma = new TreeModelA(mother);
		
    		ArrayList childnew = new ArrayList();
    		childnew.add("Clinton");
    		childnew.add("Obama");
    		public void replace(){
				Object[] data = {childnew};
				tma.set(mother,2,2,data);
    		}
		
    		ArrayList childnew2 = new ArrayList();
    		childnew2.add("Clinton");
    		childnew2.add("Obama");
    		public void replace2(){
				Tree t = (Tree)l;
				TreeModelA tma2 = (TreeModelA)t.getModel();
				Object[] data = {childnew2};
				tma2.set(tma2.getRoot(),2,2,data);
    		}
    	]]></zscript>
    	<vbox>
    		<label value="1.Click on serialize tree, there should be 2 trees" />
    		<label value='2.Click on "Replace", only upper tree is updated, lower one is NOT' />
    		<label value='3.Click on "Relace 2", only the lower tree is updated' />
    	</vbox>
    	<vbox id="vb">
    		<tree model="${tma}" id="tree" >
    		</tree>
    		<button label="Replace" onClick="replace();" />
    		<button label="Replace 2" onClick="replace2();" />
    	</vbox>

   		<button label="serialize tree" onClick="serialize(tree)"/>
    	</window>
   }

    runZTL(zscript,
        () => {
        
        	//Click 'serialize tree'
            click(jq("@button:eq(2)"));
            waitResponse();
            
            //Check 2 trees
            verifyTrue(jq(".z-tree:eq(0)").isVisible());
            verifyTrue(jq(".z-tree:eq(1)").isVisible());
            
            //Click 'replace'
            click(jq("@button:eq(0)"));
            waitResponse();
            
            var j1=jq(".z-tree:eq(0) .z-treecell:eq(2)");
            var j2=jq(".z-tree:eq(1) .z-treecell:eq(2)");
            val txt1=getText(j1);
            val txt2=getText(j2);
            
            val l2="Matter";
            val l1="[Clinton, Obama]";
            
            //Tree 1 is modified
            verifyEquals(txt1.trim(), l1);
            
            //Tree 2 not modified
            verifyEquals(txt2.trim(), l2);
                        
            //Click 'replace 2'
            click(jq("@button:eq(1)"));
            waitResponse();
                
            
            val j21=jq(".z-tree:eq(0) .z-treecell:eq(2)");
            val j22=jq(".z-tree:eq(1) .z-treecell:eq(2)");
            
            //Tree 1 is not modified
            val txt21=getText(j21);
            verifyEquals(txt21.trim(), l1);

            //Tree 2 is modified
            val txt22=getText(j22);
            verifyEquals(txt22.trim(), l1);
            
            
        }
    );
   }
}
