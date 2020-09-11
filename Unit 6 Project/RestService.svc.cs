using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Unit6Project
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "RestService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select RestService.svc or RestService.svc.cs at the Solution Explorer and start debugging.
    public class RestService : IRestService
    {
        public string healthIndicator(string weightS, string heightS)
        {
            string text = "";
            int weight = Int32.Parse(weightS);
            int height = Int32.Parse(heightS);
            double BMIcalc = BMI(weightS, heightS);
            if (BMIcalc < 18)
                text = "You are underweight";
            else if (BMIcalc < 25)
                text = "Your weight is normal";
            else if (BMIcalc < 30)
                text = "You are pre-obese";
            else
                text = "You are obese";

            return text;
        }
        public double BMI(string weightS, string heightS)
        {
            int weight = Int32.Parse(weightS);
            int height = Int32.Parse(heightS);
            double w = (double)weight;
            double h = (double)height;
            double BMI = (w / (h * h)) * 703;
            return BMI;
        }
    }
}
