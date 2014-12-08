package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2394.zul")
class B70_ZK_2394Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
  <label multiline="true">
  1. click the button
  2. you should see zk.log shows two "Yes" to indicate the table width is the same with colgroup width
  </label>
  <script type="text/javascript"><![CDATA[

  	function getWidth() {
  		var hdcolwidth = 0;
  		var hdtblwidth = $('.z-grid-header>table').width();
  		$('.z-grid-header>table>colgroup').children().each(function() {
      		hdcolwidth = hdcolwidth + $(this).width();
		});
		zk.log(Math.abs(hdtblwidth-hdcolwidth) < 1? 'Yes' : 'No');
		
		var bdcolwidth = 0;
		var bdtblwidth = $('.z-grid-body>table').width();
  		$('.z-grid-body>table>colgroup').children().each(function() {
      		bdcolwidth = bdcolwidth + $(this).width();
		});
		zk.log(Math.abs(bdtblwidth-bdcolwidth) < 1? 'Yes' : 'No');
  	}
  ]]></script>
  <button label="button" onClick='Clients.evalJavaScript("getWidth()")' />
  <grid>
    <columns>
      <column hflex="min" label="Column1"/>
      <column hflex="min" label="Column2"/>
    </columns>
    <rows>
      <row>
        <cell><label value="Label"/></cell>
        <cell><label value="Label2"/></cell>
      </row>
      <row>
        <cell><label value="Label"/></cell>
        <cell><label value="Label2"/></cell>
      </row>
      <row>
        <cell><label value="Label"/></cell>
        <cell><label value="Label2"/></cell>
      </row>
    </rows>
  </grid>
</zk>


"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-button");
      click(btn);
      waitResponse();
      var text = jq("#zk_log").eval("val()");
      var first = text.split("\n")(0);
      var second = text.split("\n")(1);
      
      verifyTrue("Yes".equals(first) && "Yes".equals(second));
    })
    
  }
}