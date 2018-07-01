package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1852.zul")
class B65_ZK_1852Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<window>
	Click the button, should show "".
	<separator/>
	<button label="Click">
		<attribute name="onClick"><![CDATA[
			Locale locale = org.zkoss.util.Locales.getLocale("zh_TW");
		    session.setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, locale);
		    execution.sendRedirect(null);
		]]></attribute>
	</button>
	<script><![CDATA[
		zk.log(jq(".z-temp .z-loading-indicator").text());
	]]></script>
</window>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        sleep(2000)

        verifyContains("should show ''.", getZKLog(), "")
      })

  }
}