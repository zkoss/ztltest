/* B35_2078184Test.scala

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
import org.zkoss.ztl.Widget
import org.zkoss.ztl.Element
import org.junit.Test

/**
 * A test class for bug 2078184
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2078184.zul,A,E,Spinner")
class B35_2078184Test extends ZTL4ScalaTestCase {
	
  @Test
  def testClick() = {
    val zscript = """
<zk>
<vbox>
<label value="1.scroll down the scrollbar"/>
<label value="2.click arrow-down button"/>
<label value="3.the value should be decreased instead of increased"/>
</vbox>
<div id="div1" height="300px" style="overflow: scroll;position:relative" width="200px">
<div height="400px">
<div height="100px"/>
<spinner id="sp1"/>
<spinner id="sp2"/>
</div>
</div>
</zk>


    """

    runZTL(zscript,
        () => {
        	
        	//Scroll down
        	jq("$div1").get(0).eval("scrollTop = 40");
        	waitResponse();
        	
        	//click spinner1 button down
        	var ds: Widget = engine.$f("sp1");
        	var dsInp: Element = ds.$n("real");
        	click(ds.$n("btn-down"));
        	
        	waitResponse();
        	
        	var v=getValue(dsInp);
        	verifyEquals(v,"-1");
        	
        	//click spinner again
        	click(ds.$n("btn-down"));
        	
        	waitResponse();
        	
        	v=getValue(dsInp);
        	verifyEquals(v,"-2");
        	
        	
        	//click spinner2 button down
        	var ds2: Widget = engine.$f("sp2");
        	var ds2Inp: Element = ds2.$n("real");
        	click(ds2.$n("btn-down"));
        	
        	waitResponse();
        	
        	var v2=getValue(ds2Inp);
        	verifyEquals(v2,"-1");
        	
        	//click spinner again
        	click(ds2.$n("btn-down"));
        	
        	waitResponse();
        	
        	v2=getValue(ds2Inp);
        	verifyEquals(v2,"-2");
        	                    
        }
    );
   }
}
