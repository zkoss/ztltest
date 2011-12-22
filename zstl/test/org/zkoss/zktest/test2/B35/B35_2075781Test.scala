/* B35_2075781Test.scala

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
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll

/**
 * A test class for bug 2075781
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2075781.zul,A,E,Columnlayout")
class B35_2075781Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
    		<?xml version="1.0" encoding="UTF-8"?>

<!--
F35-2002986.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Jun 26 19:11:57 TST 2008, Created by gracelin
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window>
	1. Press the &quot;add&quot; button, and see the new column of columnlayout is 50% of right remainder width.
	<separator/>
	2. Press the &quot;remove&quot; button, and see the column disappear.
	<separator />
	3. it shouldn't pop-up error window when click remove.

	<columnlayout id="cl">
		<columnchildren id="ch" width="200px" style="padding: 5px">
			<panel height="100px" title="column" border="normal"
			 	maximizable="true" collapsible="true">
			 	<panelchildren>Panel</panelchildren>	
			 </panel>
		</columnchildren>
	</columnlayout>
	
<zscript>
	import org.zkoss.zkmax.zul.Columnchildren;
	import org.zkoss.zul.Spinner;
	
	Columnchildren[] cc = new Columnchildren[15];
	int count = 0;
	
	public void add() {
		if (count > 14) return;
		
		cc[count] = new Columnchildren();
        cc[count].setId("ch"+count);
		cc[count].setWidth("50%");
		cc[count].setParent(cl);
		
		Panel p = new Panel();
		p.setHeight("100px");
		p.setStyle("padding: 5px");
		p.setTitle("column " + count);
		p.setBorder("normal");
		
		
		Panelchildren pc = new Panelchildren();
		Label l = new Label("test");
		l.setParent(pc);
		pc.setParent(p);
		p.setParent(cc[count]);
		count++;
	}
	public void remove() {
		if (count > 0)
			cc[--count].detach();
	}
</zscript>

	<button id="add" label="add" onClick="add()" />
	<button id="remove" label="remove" onClick="remove()" />
</window>

    """

    runZTL(zscript,
        () => {
        	
            waitResponse();
          
            //button add
            val add=jq("$add");
            click(add);
            
            waitResponse();
            
            //column added
            val ch1=jq("$ch0");
            verifyTrue(ch1.exists());
            
            //Column size 50% of remainder width
            val cl=jq(".z-columnlayout-inner");
            val c1=jq("$ch0"); 
            var w=cl.width();
            var w1=c1.width();
            var dif=(w-200)/2-w1-5; //padding 5px
            verifyTrue(dif==0);
            
            
            //button remove
            val remove=jq("$remove");
            click(remove);
            
            waitResponse();

            //Column removed
            verifyFalse(ch1.exists());
            
            //No error message
            verifyFalse(jq(".z-msgbox-error").exists());
            verifyFalse(jq(".z-errbox").exists());
			verifyFalse(jq(".z-error").exists());
            
            
        	
        }
    );
   }
}
