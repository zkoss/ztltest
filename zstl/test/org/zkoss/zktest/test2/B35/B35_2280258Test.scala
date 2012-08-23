/* B35_2280258Test.scala

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
 * A test class for bug 2280258
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2280258.zul,B,E,Hbox,Splitter")
class B35_2280258Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2280258.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Nov 14 10:04:06     2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
You should see the width of the cell is as well as its label.
<hbox id="hbox" style="border:1px solid #336" width="100px" widths="30px, 50px">
30px
<splitter/>
50px
</hbox>
</zk>

      """

    runZTL(zscript,
        () => {
        	
            waitResponse();
            var hbox=jq("$hbox");
            
            //Cell width, locate with selector by id
            var c1=hbox.toWidget().firstChild().uuid();
            var s="td[id=\""+c1+"-chdex"+"\"]";
            var ce1=jq(s).width();
           
            var c2=hbox.toWidget().lastChild().uuid();
            var s1="td[id=\""+c2+"-chdex"+"\"]";
            var ce2=jq(s1).width();
            
            //Cell text
            var c1t=getText(c1);
            var c2t=getText(c2);
            
            //Compare label and real width
            verifyEquals(c1t,ce1+"px");
            verifyTolerant(org.zkoss.ztl.ZKClientTestCase.parseInt(c2t),ce2,2);
            
        }
    );
   }
}
