import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-730TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-730TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk:zk xmlns:zul="zul" xmlns:zk="zk">
                    You shall see two buttons below that look the same.
                    <separator bar="true"/>
                    <button label="01234">
                      <attribute name="width">
                        <![CDATA[ 200px ]]>
                      </attribute>
                    </button>
                    <zul:button label="01234">
                      <zk:attribute name="width">
                        <![CDATA[ 200px ]]>
                      </zk:attribute>
                    </zul:button>
                  </zk:zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button[style]").eq(1).width(),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button[style]").eq(0).width(),
				)(),
			),
			"You shall see two buttons below that look the same.",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button[style]")
						.eq(1)
						.find(".z-button")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-button[style]")
						.eq(0)
						.find(".z-button")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
			"You shall see two buttons below that look the same.",
		);
});
