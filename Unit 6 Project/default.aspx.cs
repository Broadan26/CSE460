using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Unit6Project
{
    public partial class _default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void SOAPButton_Click(object sender, EventArgs e) //For SOAP button
        {
            //Setup the SOAP proxy
            SOAPService.SoapServiceClient proxy = new SOAPService.SoapServiceClient();
            string weightS = WeightText.Text;
            string heightS = HeightText.Text;
            string message = proxy.healthIndicator(weightS, heightS);
            double bmi = proxy.BMI(weightS, heightS);

            //Place text into fields
            SOAPBMIresult.Text = bmi.ToString();
            SOAPhealthresult.Text = message;

            //Colors just because
            colorChangeSOAP(bmi);

            //Make fields visible
            SOAPBMIresult.Visible = true;
            SOAPhealthresult.Visible = true;
        }
        protected void RESTButton_Click(object sender, EventArgs e) //For REST Button
        {
            //Pull needed data
            string weightS = WeightText.Text;
            string heightS = HeightText.Text;

            //healthIndicator Function
            string url = "http://localhost:55476/RestService.svc/healthIndicator/" + weightS + "/"+ heightS; //Change localhost as needed
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            Stream responseStream = response.GetResponseStream();
            StreamReader readerStream = new StreamReader(responseStream, System.Text.Encoding.GetEncoding("utf-8"));
            string json = readerStream.ReadToEnd();
            readerStream.Close();

            //Parse the JSON
            healthInfo h = JsonConvert.DeserializeObject<healthInfo>(json);
            //RESThealthresult.Text = json;
            RESThealthresult.Text = h.healthIndicatorResult;

            //BMI Function
            url = "http://localhost:55476/RestService.svc/BMI/" + weightS + "/" + heightS; //Change localhost as needed
            request = (HttpWebRequest)WebRequest.Create(url);
            response = (HttpWebResponse)request.GetResponse();
            responseStream = response.GetResponseStream();
            readerStream = new StreamReader(responseStream, System.Text.Encoding.GetEncoding("utf-8"));
            json = readerStream.ReadToEnd();
            readerStream.Close();

            //Parse the JSON
            BMIinfo b = JsonConvert.DeserializeObject<BMIinfo>(json);
            //RESTBMIresult.Text = json;
            RESTBMIresult.Text = b.BMIResult.ToString();

            //Colors just because
            colorChangeREST(b.BMIResult);

            //Make fields visible
            RESThealthresult.Visible = true;
            RESTBMIresult.Visible = true;
        }

        private void colorChangeSOAP(double bmi) //SOAP Colors
        {
            if (bmi < 18)
            {
                SOAPBMIresult.ForeColor = Color.Blue;
                SOAPhealthresult.ForeColor = Color.Blue;
            }
            else if (bmi < 25)
            {
                SOAPBMIresult.ForeColor = Color.Green;
                SOAPhealthresult.ForeColor = Color.Green;
            }
            else if (bmi < 30)
            {
                SOAPBMIresult.ForeColor = Color.Purple;
                SOAPhealthresult.ForeColor = Color.Purple;
            }
            else
            {
                SOAPBMIresult.ForeColor = Color.Red;
                SOAPhealthresult.ForeColor = Color.Red;
            }
        }

        private void colorChangeREST(double bmi) //REST Colors
        {
            if (bmi < 18)
            {
                RESTBMIresult.ForeColor = Color.Blue;
                RESThealthresult.ForeColor = Color.Blue;
            }
            else if (bmi < 25)
            {
                RESTBMIresult.ForeColor = Color.Green;
                RESThealthresult.ForeColor = Color.Green;
            }
            else if (bmi < 30)
            {
                RESTBMIresult.ForeColor = Color.Purple;
                RESThealthresult.ForeColor = Color.Purple;
            }
            else
            {
                RESTBMIresult.ForeColor = Color.Red;
                RESThealthresult.ForeColor = Color.Red;
            }
        }
    }

    public class healthInfo //For healthIndicator JSON object
    {
        public string healthIndicatorResult { get; set; }
    }

    public class BMIinfo //For BMI JSON object
    {
        public double BMIResult { get; set; }
    }
}