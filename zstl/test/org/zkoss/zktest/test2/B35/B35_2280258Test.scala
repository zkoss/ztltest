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
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B35-2280258.zul,B,E,Hbox,Splitter")
class B35_2280258Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      waitResponse()
      var hbox = jq("$hb")
      //Cell width, locate with selector by id
      var c1 = hbox.toWidget().firstChild().uuid();
      var s = "td[id=\"" + c1 + "-chdex" + "\"]";
      var ce1 = jq(s).width();

      var c2 = hbox.toWidget().lastChild().uuid();
      var s1 = "td[id=\"" + c2 + "-chdex" + "\"]";
      var ce2 = jq(s1).width();

      //Cell text
      var c1t = getText(c1);
      var c2t = getText(c2);

      //Compare label and real width
      verifyTolerant(parseInt(c1t), ce1, 2);
      verifyTolerant(parseInt(c2t), ce2, 2);
    }
    );
  }
}
