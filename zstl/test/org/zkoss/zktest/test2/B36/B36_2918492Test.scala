/* B36_2918492Test.scala

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
package org.zkoss.zktest.test2.B36

import java.util.Calendar

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2918492
 * @author ldnigro
 *
 */
@Tags(tags = "B36-2918492.zul,A,E,Portallayout,Maximize")
class B36_2918492Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2918492.zul

	Purpose:
		
	Description:
		
	History:
		Wed Dec 23 10:56:29 TST 2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
1. Maximize "Google Tools" and close it by pressing the X sign.
<separator/>
2. You should see the "LabPixies Clock" is shown.
<portallayout>
	<portalchildren style="padding: 5px" width="30%">
		<panel id="googletools" height="150px" title="Google Tools" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
			<panelchildren>
				<iframe width="100%" height="100%" src="http://3.gmodules.com/ig/ifr?url=http://www.google.com/ig/modules/toolspromo.xml&amp;nocache=0&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=3&amp;ifpctok=5090480830848781425&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMAs4ACwrMBA4ACwrMBI4ACwrMBM4ACw/zYieI_ujwr4.js"/>
			</panelchildren>
		</panel>
		<panel id="labpixies" height="300px" title="LabPixies Clock" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
			<panelchildren>
				<iframe width="100%" height="100%" src="http://34.gmodules.com/ig/ifr?url=http://www.labpixies.com/campaigns/clock/mini_clock.xml&amp;nocache=0&amp;up_skin_id=&amp;upt_skin_id=hidden&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=34&amp;ifpctok=-3234052241260630457&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
			</panelchildren>
		</panel>
	</portalchildren>
	
	<portalchildren style="padding: 5px" width="30%">
		<panel height="300px" title="ToDo" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
			<panelchildren>
				<iframe width="100%" height="100%" src="http://cj399o2i-a.gmodules.com/ig/ifr?url=http://www.labpixies.com/campaigns/todo/todo.xml&amp;nocache=0&amp;up_saved_tasks=&amp;upt_saved_tasks=hidden&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=31&amp;ifpctok=-1474109439244469874&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
			</panelchildren>
		</panel>
		<panel height="100px" title="Wikipedia" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
			<panelchildren>
				<iframe width="100%" height="100%" src="http://29.gmodules.com/ig/ifr?url=http://wpsearchbar.wikia.com/common/wpsearchbar.xml&amp;nocache=0&amp;up_mylang=&amp;upt_mylang=enum&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=29&amp;ifpctok=4012247812086609177&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
			</panelchildren>
		</panel>
	</portalchildren>
	
	<portalchildren style="padding: 5px" width="40%">
		<panel height="400px" title="Trio" border="normal" collapsible="true" closable="true" maximizable="true" style="margin-bottom:10px">
			<panelchildren>
				<iframe width="100%" height="100%" src="http://35.gmodules.com/ig/ifr?url=http://www.labpixies.com/campaigns/trio/trio.xml&amp;nocache=0&amp;lang=en&amp;country=us&amp;.lang=en&amp;.country=us&amp;synd=ig&amp;mid=35&amp;ifpctok=7430207052966295609&amp;parent=http://www.google.com&amp;extern_js=/extern_js/f/CgJlbhICdXMrMBI4ACwrMBM4ACw/v3vgcgA0x8g.js"/>
			</panelchildren>
		</panel>
	</portalchildren>
</portallayout>
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click maximize button
        var btn = jq("$googletools .z-panel").toWidget().$n("max");
        click(btn);
        waitResponse();

        //Check visible 
        var lab1 = jq("$labpixies");
        verifyFalse(lab1.isVisible());
        
        //Close panel
        var close = jq("$googletools .z-panel").toWidget().$n("close");
        click(close);
        waitResponse();
        
        //Check visible 
        var lab = jq("$labpixies");
        verifyTrue(lab.isVisible());
        
      });
  }
     
}