import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F50-ZK-500TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F50-ZK-500TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
				<vlayout>
					1. You should see 1,234.57
					<hlayout>
						<decimalbox locale="en_US" value="1234.567"/>
						<doublebox locale="en_US" value="1234.567"/>
						<doublespinner locale="en_US" value="1234.567"/>
					</hlayout>
					2. You should see 1,234
					<hlayout>
						<intbox locale="en_US" value="1234"/>
						<longbox locale="en_US" value="1234"/>
						<spinner locale="en_US" value="1234"/>
					</hlayout>
					3. You should see 01,123.57
					<hlayout>
						<decimalbox locale="en_US" format="00,000.00" value="1234.567"/>
						<doublebox locale="en_US" format="00,000.00" value="1234.567"/>
						<doublespinner locale="en_US" format="00,000.00" value="1234.567"/>
					</hlayout>
					4. You should see 01,234.00
					<hlayout>
						<intbox locale="en_US" format="00,000.00" value="1234"/>
						<longbox locale="en_US" format="00,000.00" value="1234"/>
						<spinner locale="en_US" format="00,000.00" value="1234"/>
					</hlayout>
					<separator/>
					<div style="border:1px solid blue">
						5. You should see 1234.567
						<hlayout>
							<decimalbox id="inp1" value="1234.567"/>
							<doublebox id="inp2" value="1234.567"/>
							<doublespinner id="inp3" value="1234.567"/>
						</hlayout>
						6. You should see 1234
						<hlayout>
							<intbox id="inp4" value="1234"/>
							<longbox id="inp5" value="1234"/>
							<spinner id="inp6" value="1234"/>
						</hlayout>
						7. Please<button label="click me">
						<attribute name="onClick"><![CDATA[
        inp1.setLocale("en_US");
      	inp2.setLocale("en_US");
      	inp3.setLocale("en_US");
      	inp4.setLocale("en_US");
      	inp5.setLocale("en_US");
      	inp6.setLocale("en_US");
						]]></attribute>
					</button>
						Then, the above 1234.567 will change to 1,234.57 and the 1234 will change to 1,234 (only inside the blue area)
					</div>
				</vlayout>
			</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox:eq(0)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@doublebox:eq(0)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(jq("@doublespinner:eq(0)")).$n("real")
							.value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@intbox:eq(0)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox:eq(0)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("@spinner:eq(0)")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox:eq(1)").val())(),
			),
		)
		.eql(ztl.normalizeText("01,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@doublebox:eq(1)").val())(),
			),
		)
		.eql(ztl.normalizeText("01,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(jq("@doublespinner:eq(1)")).$n("real")
							.value,
				)(),
			),
		)
		.eql(ztl.normalizeText("01,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@intbox:eq(1)").val())(),
			),
		)
		.eql(ztl.normalizeText("01,234.00"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox:eq(1)").val())(),
			),
		)
		.eql(ztl.normalizeText("01,234.00"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("@spinner:eq(1)")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("01,234.00"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1234.567"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@doublebox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1234.567"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(jq("@doublespinner:eq(2)")).$n("real")
							.value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1234.567"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@intbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("@spinner:eq(2)")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1234"));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@decimalbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@doublebox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() =>
						zk.Widget.$(jq("@doublespinner:eq(2)")).$n("real")
							.value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1,234.57"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@intbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@longbox:eq(2)").val())(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => zk.Widget.$(jq("@spinner:eq(2)")).$n("real").value,
				)(),
			),
		)
		.eql(ztl.normalizeText("1,234"));
});
