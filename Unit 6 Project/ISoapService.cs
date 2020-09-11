using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Unit6Project
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ISoapService" in both code and config file together.
    [ServiceContract]
    public interface ISoapService
    {
        [OperationContract]
        [WebGet]
        string healthIndicator(string weightS, string heightS);

        [OperationContract]
        [WebGet]
        double BMI(string weightS, string heightS);
    }
}