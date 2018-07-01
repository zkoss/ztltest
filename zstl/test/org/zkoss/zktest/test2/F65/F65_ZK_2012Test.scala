package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

@Tags(tags = "F65-ZK-2012.zul")
@IgnoreBrowsers("chrome,ff,safari,edge,ie10,ie9")
class F65_ZK_2012Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<window apply="org.zkoss.zktest.test2.F65_ZK_2012_Composer">
		<div>1. should see 'zk.ie: 11, zk.ff: false' in zk.log</div>
		<div width="400px">
			2. click button, then should show
			<div>'true' in 'isBrowser(ie)' textbox,</div>
			<div>'false' in 'isBrowser(ff)' textbox,</div>
			<div>'true' in 'isBrowser(ie11)' textbox,</div>
			<div>'ie' in 'getBrowser' textbox.</div>
			<div>
				'[11.0, 7.0, 11.0]' in 'getIECompatibilityInfo' textbox.
			</div>
		</div>
		<script>
			<![CDATA[			
			zk.afterLoad('zul.wgt', function() { 
				zk.log('zk.ie: ' + zk.ie); 
				zk.log('zk.ff: ' + zk.ff);
			});
			]]>
		</script>
		<div>
			<button id="button" label="isBrowser, getBrowser"></button>
			<vlayout>
				<label value="isBrowser(ie)" />
				<textbox id="ie" />
				<label value="isBrowser(ff)" />
				<textbox id="ff" />
				<label value="isBrowser(ie11)" />
				<textbox id="ie11" />
				<label value="getBrowser" />
				<textbox id="get" />
				<label value="getIECompatibilityInfo" />
				<textbox id="getcomp" />
			</vlayout>
		</div>
		<div>
			3. check EL, should show {version=11.0, name=ie}, 11.0
		</div>
		<div>
			<vlayout>
				<label value="${zk.browser}" />
				<label value="${zk.ie}" />
				<label value="${zk.ff}" />
				<label value="${zk.gecko}" />
			</vlayout>
		</div>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val log = jq("#zk_log").`val`()
        verifyContains("should see 'zk.ie: 11, zk.ff: false' in zk.log", log, "zk.ie: 11")
        verifyContains("should see 'zk.ie: 11, zk.ff: false' in zk.log", log, "zk.ff: false")
        click(jq(".z-button"))
        waitResponse()

        verifyTrue(jq(".z-textbox").eq(0).`val`() == "true")
        verifyTrue(jq(".z-textbox").eq(1).`val`() == "false")
        verifyTrue(jq(".z-textbox").eq(2).`val`() == "true")
        verifyTrue(jq(".z-textbox").eq(3).`val`() == "ie")
        verifyTrue(jq(".z-textbox").eq(4).`val`() == "[11.0, 7.0, 11.0]")
        verifyTrue(jq(".z-vlayout:eq(1) .z-label:contains({version=11.0, name=ie}), " +
          ".z-vlayout:eq(1) .z-label:contains({name=ie, version=11.0})").exists())
        verifyTrue(jq(".z-vlayout:eq(1) .z-label:contains(11)").length() == 2)
      })
  }
}