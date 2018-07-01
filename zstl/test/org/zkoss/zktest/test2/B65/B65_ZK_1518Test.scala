package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1518.zul")
class B65_ZK_1518Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	Should not see any error message showed.
	<decimalbox id="dbx" />
	<zscript><![CDATA[
		dbx.setLocale(java.util.Locale.GERMAN);
		dbx.setFormat("#,##0.0###");
		dbx.setValue(new java.math.BigDecimal(123456.1234));
	]]></zscript>
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("should not see any error message.", !jq(".z-errorbox").exists())
      })

  }
}
