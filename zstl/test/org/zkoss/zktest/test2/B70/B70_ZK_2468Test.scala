package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2468.zul")
class B70_ZK_2468Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<zk>
	<label multiline="true">
	  1. click the button
	  2. you should see zk.log shows "Yes" to indicate the grid body width is the same with grid body table width
	  </label>
	  <script type="text/javascript">
	  	function getWidth() {
			var bdwidth = $('.z-grid-body').width();
			var bdtblwidth = $('.z-grid-body>table').width();
			zk.log(bdtblwidth==bdwidth? 'Yes' : 'No');
	  	}
	  </script>
	  <button label="button" onClick='Clients.evalJavaScript("getWidth()")' />
	<window border="normal" title="hello" height="400px">

		<grid vflex="true" span="true">
			<frozen columns="1" />
			<columns>
				<column label="1" />
				<column label="2" />
				<column label="3" />
			</columns>
			<rows>
				<row>
					<cell>
						<label value="1" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="3" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="4" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="5" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="6" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="7" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="8" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="9" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="10" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="11" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="12" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="13" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="14" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
				<row>
					<cell>
						<label value="15" />
					</cell>
					<cell>
						<label value="2" />
					</cell>
					<cell>
						<label value="3" />
					</cell>
				</row>
			</rows>
		</grid>
	</window>
	
</zk>


"""  
  runZTL(zscript,
    () => {
      
      val btn = jq(".z-button");
      click(btn);
      waitResponse();
      var text = jq("#zk_log").eval("val()");      
      verifyTrue("Yes".equals(text.trim()));
      
    })
    
  }
}