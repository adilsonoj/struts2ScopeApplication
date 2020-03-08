<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<head>

<s:head debug="true" />

</head>

<body>

	<s:div id="loginDiv">

		<h3>
			Your Session:
			<s:property value="#session.ret" />
		</h3>

		<div style="width: 300px; border-style: solid">

			<s:form action="/test" validate="false">

				<tr>

					<td colspan="2">Run Test</td>

				</tr>

				<tr>

					<td colspan="2"><s:actionerror /> <s:fielderror /> <s:actionmessage />

					</td>

					<s:textfield name="welcome1" label="WELCOME1" />

					<s:textfield name="welcome2" label="WELCOME2" />

					<s:submit value="Submit" />

				</tr>

			</s:form>

		</div>

	</s:div>

</body>

</html>