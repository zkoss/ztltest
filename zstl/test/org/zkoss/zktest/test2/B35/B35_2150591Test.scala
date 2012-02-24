/* B35_2150591Test.scala

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
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags


/**
 * A test class for bug 2150591
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2150591.zul,A,E,Group,Listgroup,Grid,Listbox")
class B35_2150591Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2150591.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Oct  7 11:02:50     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
<listbox id="lb" width="200px">
<listgroup label="Listgroup" id="lg"/>
<listitem label="Listitem"/>
<listgroupfoot id="lgf" label="Listgroupfoot"/>
<listgroup label="Listgroup" id="lg2"/>
<listitem label="Listitem"/>
</listbox>
<button id="but1" label="After click me, Listgroupfoot should be replaced" onClick='if (lgf != lb.getLastChild()) lb.insertBefore(lgf, null); else lb.insertBefore(lgf, lg2);'/>
<button id="but2" label="After click me, Listgroup and Listgroupfoot should be removed" onClick='lg.detach(); lg2.detach();'/>
<grid width="200px">
<rows id="rs">
<group label="Group" id="g"/>
<row><label value="Row"/></row>
<groupfoot id="gf" label="Groupfoot"/>
<group id="g2" label="Group" />
<row><label value="Row"/></row>
</rows>
</grid>
<button id="but3" label="After click me, Groupfoot should be replaced" onClick='if (gf != rs.getLastChild()) rs.insertBefore(gf, null); else rs.insertBefore(gf, g2);'/>
<button id="but4" label="After click me, Group and Groupfoot should be removed" onClick='g.detach(); g2.detach();'/>
</zk>

      """

    runZTL(zscript,
        () => {
        	
            waitResponse();
            
            //1 - Listgroupfoot replaced
        	click(jq("$but1"));
        	waitResponse();
        	
        	
        	var id=jq("$lb").toWidget().lastChild().id();
        	verifyEquals(id,"lgf");
        	
        	//2 - Listgroup & Listfoot removed
        	click(jq("$but2"));
        	waitResponse();
        	
        	verifyFalse(jq(".z-listgroup").exists());
        	verifyFalse(jq(".z-listgroupfoot").exists());
        	
        	//3 - Groupfoot replaced
        	click(jq("$but3"));
        	waitResponse();
        	
        	var id1=jq("$rs").toWidget().lastChild().id();
        	verifyEquals(id1,"gf");
        	
        	//4 - Group & groupfoot replaced
        	click(jq("$but4"));
        	waitResponse();
        	
        	verifyFalse(jq(".z-group").exists());
        	verifyFalse(jq(".z-groupfoot").exists());

                   
        }
    );
   }
}
