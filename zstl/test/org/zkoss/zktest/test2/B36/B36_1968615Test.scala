/* B36_1968615Test.scala

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
import org.junit.Test

/**
 * A test class for bug 3000305
 * @author ldnigro
 *
 */
@Tags(tags = "B36-1968615.zul,A,E,Databind,Constraint")
class B36_1968615Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {

        waitResponse();

        //1. You shall see three rows.  
        var lb=jq("$lb").toWidget();
        var nc=lb.nChildren();
        verifyEquals(nc,3);
        
        // 1st row and 2nd row has two column.
        var r1=lb.firstChild();
        var n1=r1.nChildren();
        verifyEquals(n1,2);
        
        var r2=r1.nextSibling();
        var n2=r2.nChildren();
        verifyEquals(n2,2);
        
        //3rd row has only one spanned column
        var r3=lb.lastChild();
        var n3=r3.nChildren();
        verifyEquals(n3,1);
 
        //2. 2nd column of the 1st row and 2nd row are also a Grid of 3 rows.
        var r12=jq(r1.firstChild().nextSibling()).find(".z-listbox");
        var r12v=r12.isVisible()
        verifyTrue(r12v);
        verifyEquals(r12.toWidget().nChildren(),3);
        
        var r22=jq(r2.firstChild().nextSibling()).find(".z-listbox");
        var r22v=r22.isVisible();
        verifyTrue(r22v);
        verifyEquals(r22.toWidget().nChildren(),3);
        
        //3. You shall see on 1st column of the 1st row: [AAA, AAB]
        var txt1=getText(jq(r1.firstChild())).trim;
        verifyEquals("[AAA, AAB]", txt1);
        
        //4. You shall see on 2nd column of the 1st row: AAA, AAB, and [AAA, AAB]
        var r121=jq(r12.toWidget().firstChild());
        var r122=jq(r12.toWidget().firstChild().nextSibling());
        var r123=jq(r12.toWidget().lastChild());
        
        var r121t=getText(r121).trim;
        var r122t=getText(r122).trim;
        var r123t=getText(r123).trim;
        
        verifyEquals(r121t,"AAA");
        verifyEquals(r122t,"AAB");
        verifyEquals(r123t,"[AAA, AAB]");
              
        
        //5. You shall see on 1st column of the 2nd row: [BAA, BAB]
        var txt2=getText(jq(r2.firstChild())).trim;
        verifyEquals(txt2,"[BAA, BAB]");
        
        //6. You shall see on 2nd column of the 2nd row: BAA, BAB, and [BAA, BAB]
        var r221=jq(r22.toWidget().firstChild());
        var r222=jq(r22.toWidget().firstChild().nextSibling());
        var r223=jq(r22.toWidget().lastChild());
        
        var r221t=getText(r221).trim;
        var r222t=getText(r222).trim;
        var r223t=getText(r223).trim;
        
        verifyEquals(r221t,"BAA");
        verifyEquals(r222t,"BAB");
        verifyEquals(r223t,"[BAA, BAB]");
        
        //7. You shall see on 3rd row: [[AAA, AAB],[BAA, BAB]]
        var txt7=getText(jq(r3.firstChild())).trim;
        verifyEquals(txt7,"[[AAA, AAB], [BAA, BAB]]");
        
        waitResponse();
      });
  }
     
}
