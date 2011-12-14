/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_B00605Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // B00605.zul
      <window xmlns:n="http://www.zkoss.org/2005/zk/native" title="outter" border="normal" apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.B00605')">
        the value binding in outter, inner1 and inner2 should work separately,<n:br/>
        1.change outter value to JJ, only effect value in outter .<n:br/>
        2.change inner 1 value to KK, should only effect value in inner1<n:br/>
        3.click doInclude, the inner 2 value should be 'A', it should not the value you changed in outter<n:br/>
        4.change the inner 2 value, should only effect value in inner 2<n:br/>
        5.change the outer value, it only effect value of outter, (not effect value of inner 1 and 2)<n:br/>
        <vbox>
          ==Outter==
          <hbox>
            <textbox id="tb1" value="@bind(vm.value)"/>
            <label id="lb1" value="@bind(vm.value)"/>
          </hbox>
          ==Include 1==
          <include id="inc1" src="bind/issue/B00605-1.zul"/>
          ==Include 2==
          <include id="inc2"/>
          <hbox>
            <button id="btn1" label="doInclude" onClick='inc2.src="bind/issue/B00605-2.zul"'/>
            <button label="Dump" onClick="binder.getTracker().dump()"/>
          </hbox>
          ====
        </vbox>
      </window>
    }

    runZTL(zul, () => {
      verifyEquals("A", engine.$f("tb1").get("value"));
      verifyEquals("A", engine.$f("lb1").get("value"));
      verifyEquals("A", engine.$f("tb2").get("value"));
      verifyEquals("A", engine.$f("lb2").get("value"));
      verifyTrue(!engine.$f("tb3").exists()); // no need to wait it is not exist in init
      verifyTrue(!engine.$f("lb3").exists()); // no need to wait it is not exist in init
      
      `type`(engine.$f("tb1"), "JJ");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("A", engine.$f("tb2").get("value"));
      verifyEquals("A", engine.$f("lb2").get("value"));
      
      `type`(engine.$f("tb2"), "KK");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));
      
      click(engine.$f("btn1"));
      waitResponse();
      verifyEquals("A", engine.$f("tb3").get("value"));
      verifyEquals("A", engine.$f("lb3").get("value"));
      
      `type`(engine.$f("tb3"), "LL");
      waitResponse();
      verifyEquals("JJ", engine.$f("tb1").get("value"));
      verifyEquals("JJ", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));
      
      // test again since inc2 is here
      `type`(engine.$f("tb1"), "X");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("KK", engine.$f("tb2").get("value"));
      verifyEquals("KK", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));
      
      `type`(engine.$f("tb2"), "Y");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("Y", engine.$f("tb2").get("value"));
      verifyEquals("Y", engine.$f("lb2").get("value"));
      verifyEquals("LL", engine.$f("tb3").get("value"));
      verifyEquals("LL", engine.$f("lb3").get("value"));
      
      `type`(engine.$f("tb3"), "Z");
      waitResponse();
      verifyEquals("X", engine.$f("tb1").get("value"));
      verifyEquals("X", engine.$f("lb1").get("value"));
      verifyEquals("Y", engine.$f("tb2").get("value"));
      verifyEquals("Y", engine.$f("lb2").get("value"));
      verifyEquals("Z", engine.$f("tb3").get("value"));
      verifyEquals("Z", engine.$f("lb3").get("value"));
    })
  }
}
