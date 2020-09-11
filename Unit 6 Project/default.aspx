<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="default.aspx.cs" Inherits="Unit6Project._default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div style="margin-left: auto; margin-right: auto; text-align: center;">
            <asp:Label ID="WebTitle" runat="server" Text="Unit 6 SOC Project" Font-Bold="True" Font-Size="X-Large" Font-Underline="False" ForeColor="#0000CC"></asp:Label>
            <hr />
            <br /> <br />
        </div>
        <div>
            <asp:Label ID="HeightLabel" runat="server" Text="Height: "></asp:Label>
            &emsp; &emsp; &emsp; &emsp;
            <asp:TextBox ID="HeightText" runat="server"></asp:TextBox>
            <br />
        </div>
        <div>
            <asp:Label ID="WeightLabel" runat="server" Text="Weight:"></asp:Label>
            &emsp; &emsp; &emsp; &emsp;
            <asp:TextBox ID="WeightText" runat="server"></asp:TextBox>
            <br /> <br />
        </div>
        <div>
            <asp:Label ID="SOAPCall" runat="server" Text="SOAP Service Call" Font-Bold="True"></asp:Label>
            &emsp; &emsp;
            <asp:Label ID="SOAPBMI" runat="server" Text="BMI: " Font-Bold="True"></asp:Label>
            <asp:Label ID="SOAPBMIresult" runat="server" Text="20.0 " Visible="False"></asp:Label>
            &emsp; &emsp;
            <asp:Label ID="SOAPhealth" runat="server" Text="Health Indicator: " Font-Bold="True"></asp:Label>
            <asp:Label ID="SOAPhealthresult" runat="server" Text="nothing" Visible="False"></asp:Label>
            <br /> <br />
            <asp:Button ID="SOAPButton" runat="server" Text="Call SOAP API" Font-Bold="True" Font-Size="Medium" OnClick="SOAPButton_Click" />
            <br /> <br /> <br />
        </div>
        <div>
            <asp:Label ID="RESTCall" runat="server" Text="REST Service API " Font-Bold="True"></asp:Label>
            &emsp; &emsp;
            <asp:Label ID="RESTBMI" runat="server" Text="BMI: " Font-Bold="True"></asp:Label>
            <asp:Label ID="RESTBMIresult" runat="server" Text="20.0 " Visible="False"></asp:Label>
            &emsp; &emsp;
            <asp:Label ID="RESThealth" runat="server" Text="Health Indicator: " Font-Bold="True"></asp:Label>
            <asp:Label ID="RESThealthresult" runat="server" Text="nothing" Visible="False"></asp:Label>
            <br /> <br />
            <asp:Button ID="RESTButton" runat="server" Text="Call REST API" Font-Bold="True" Font-Size="Medium" OnClick="RESTButton_Click" />
        </div>
    </form>
</body>
</html>