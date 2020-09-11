using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Unit6Project
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IRestService" in both code and config file together.
    [ServiceContract]
    public interface IRestService
    {
        [OperationContract]
        [WebInvoke( 
            Method = "GET", 
            UriTemplate = "/healthIndicator/{weightS}/{heightS}",
            BodyStyle = WebMessageBodyStyle.Wrapped, 
            RequestFormat = WebMessageFormat.Json, 
            ResponseFormat = WebMessageFormat.Json)]
        string healthIndicator(string weightS, string heightS);

        [OperationContract]
        [WebInvoke(
            Method = "GET",
            UriTemplate = "/BMI/{weightS}/{heightS}",
            BodyStyle = WebMessageBodyStyle.Wrapped,
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json)]
        double BMI(string weightS, string heightS);
    }
}