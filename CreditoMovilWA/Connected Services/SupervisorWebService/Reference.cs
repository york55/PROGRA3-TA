﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace CreditoMovilWA.SupervisorWebService {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", ConfigurationName="SupervisorWebService.SupervisorWS")]
    public interface SupervisorWS {
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/obtenerSupervisorPorIdReque" +
            "st", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/obtenerSupervisorPorIdRespo" +
            "nse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(usuario))]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse obtenerSupervisorPorId(CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/obtenerSupervisorPorIdReque" +
            "st", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/obtenerSupervisorPorIdRespo" +
            "nse")]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse> obtenerSupervisorPorIdAsync(CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest request);
        
        // CODEGEN: El parámetro 'idSupervisor' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/modificarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/modificarSupervisorResponse" +
            "")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(usuario))]
        CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse modificarSupervisor(CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/modificarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/modificarSupervisorResponse" +
            "")]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse> modificarSupervisorAsync(CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest request);
        
        // CODEGEN: El parámetro 'idSupervisor' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/eliminarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/eliminarSupervisorResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(usuario))]
        CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse eliminarSupervisor(CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/eliminarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/eliminarSupervisorResponse")]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse> eliminarSupervisorAsync(CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest request);
        
        // CODEGEN: El parámetro 'return' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/listarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/listarSupervisorResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(usuario))]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        CreditoMovilWA.SupervisorWebService.listarSupervisorResponse listarSupervisor(CreditoMovilWA.SupervisorWebService.listarSupervisorRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/listarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/listarSupervisorResponse")]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.listarSupervisorResponse> listarSupervisorAsync(CreditoMovilWA.SupervisorWebService.listarSupervisorRequest request);
        
        // CODEGEN: El parámetro 'credito' requiere información adicional de esquema que no se puede capturar con el modo de parámetros. El atributo específico es 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/insertarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/insertarSupervisorResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [System.ServiceModel.ServiceKnownTypeAttribute(typeof(usuario))]
        CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse insertarSupervisor(CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://services.creditomovil.pucp.edu.pe/SupervisorWS/insertarSupervisorRequest", ReplyAction="http://services.creditomovil.pucp.edu.pe/SupervisorWS/insertarSupervisorResponse")]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse> insertarSupervisorAsync(CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest request);
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.9037.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/")]
    public partial class supervisor : usuario {
        
        private string agenciaAsignacionField;
        
        private string codigoEvField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string agenciaAsignacion {
            get {
                return this.agenciaAsignacionField;
            }
            set {
                this.agenciaAsignacionField = value;
                this.RaisePropertyChanged("agenciaAsignacion");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string codigoEv {
            get {
                return this.codigoEvField;
            }
            set {
                this.codigoEvField = value;
                this.RaisePropertyChanged("codigoEv");
            }
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(supervisor))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.8.9037.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/")]
    public abstract partial class usuario : object, System.ComponentModel.INotifyPropertyChanged {
        
        private bool activoField;
        
        private string apMaternoField;
        
        private string apPaternoField;
        
        private string contrasenhaField;
        
        private System.DateTime fechaField;
        
        private bool fechaFieldSpecified;
        
        private System.DateTime fechaVencimientoField;
        
        private bool fechaVencimientoFieldSpecified;
        
        private int idUsuarioField;
        
        private string nombreField;
        
        private System.DateTime ultimoLogueoField;
        
        private bool ultimoLogueoFieldSpecified;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public bool activo {
            get {
                return this.activoField;
            }
            set {
                this.activoField = value;
                this.RaisePropertyChanged("activo");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string apMaterno {
            get {
                return this.apMaternoField;
            }
            set {
                this.apMaternoField = value;
                this.RaisePropertyChanged("apMaterno");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public string apPaterno {
            get {
                return this.apPaternoField;
            }
            set {
                this.apPaternoField = value;
                this.RaisePropertyChanged("apPaterno");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public string contrasenha {
            get {
                return this.contrasenhaField;
            }
            set {
                this.contrasenhaField = value;
                this.RaisePropertyChanged("contrasenha");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public System.DateTime fecha {
            get {
                return this.fechaField;
            }
            set {
                this.fechaField = value;
                this.RaisePropertyChanged("fecha");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool fechaSpecified {
            get {
                return this.fechaFieldSpecified;
            }
            set {
                this.fechaFieldSpecified = value;
                this.RaisePropertyChanged("fechaSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public System.DateTime fechaVencimiento {
            get {
                return this.fechaVencimientoField;
            }
            set {
                this.fechaVencimientoField = value;
                this.RaisePropertyChanged("fechaVencimiento");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool fechaVencimientoSpecified {
            get {
                return this.fechaVencimientoFieldSpecified;
            }
            set {
                this.fechaVencimientoFieldSpecified = value;
                this.RaisePropertyChanged("fechaVencimientoSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public int idUsuario {
            get {
                return this.idUsuarioField;
            }
            set {
                this.idUsuarioField = value;
                this.RaisePropertyChanged("idUsuario");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=7)]
        public string nombre {
            get {
                return this.nombreField;
            }
            set {
                this.nombreField = value;
                this.RaisePropertyChanged("nombre");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=8)]
        public System.DateTime ultimoLogueo {
            get {
                return this.ultimoLogueoField;
            }
            set {
                this.ultimoLogueoField = value;
                this.RaisePropertyChanged("ultimoLogueo");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool ultimoLogueoSpecified {
            get {
                return this.ultimoLogueoFieldSpecified;
            }
            set {
                this.ultimoLogueoFieldSpecified = value;
                this.RaisePropertyChanged("ultimoLogueoSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="obtenerSupervisorPorId", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class obtenerSupervisorPorIdRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int idSupervisor;
        
        public obtenerSupervisorPorIdRequest() {
        }
        
        public obtenerSupervisorPorIdRequest(int idSupervisor) {
            this.idSupervisor = idSupervisor;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="obtenerSupervisorPorIdResponse", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class obtenerSupervisorPorIdResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public CreditoMovilWA.SupervisorWebService.supervisor @return;
        
        public obtenerSupervisorPorIdResponse() {
        }
        
        public obtenerSupervisorPorIdResponse(CreditoMovilWA.SupervisorWebService.supervisor @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="modificarSupervisor", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class modificarSupervisorRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int idSupervisor;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public CreditoMovilWA.SupervisorWebService.supervisor supervisor;
        
        public modificarSupervisorRequest() {
        }
        
        public modificarSupervisorRequest(int idSupervisor, CreditoMovilWA.SupervisorWebService.supervisor supervisor) {
            this.idSupervisor = idSupervisor;
            this.supervisor = supervisor;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="modificarSupervisorResponse", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class modificarSupervisorResponse {
        
        public modificarSupervisorResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="eliminarSupervisor", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class eliminarSupervisorRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int idSupervisor;
        
        public eliminarSupervisorRequest() {
        }
        
        public eliminarSupervisorRequest(int idSupervisor) {
            this.idSupervisor = idSupervisor;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="eliminarSupervisorResponse", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class eliminarSupervisorResponse {
        
        public eliminarSupervisorResponse() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="listarSupervisor", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class listarSupervisorRequest {
        
        public listarSupervisorRequest() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="listarSupervisorResponse", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class listarSupervisorResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public CreditoMovilWA.SupervisorWebService.supervisor[] @return;
        
        public listarSupervisorResponse() {
        }
        
        public listarSupervisorResponse(CreditoMovilWA.SupervisorWebService.supervisor[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="insertarSupervisor", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class insertarSupervisorRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://services.creditomovil.pucp.edu.pe/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public CreditoMovilWA.SupervisorWebService.supervisor credito;
        
        public insertarSupervisorRequest() {
        }
        
        public insertarSupervisorRequest(CreditoMovilWA.SupervisorWebService.supervisor credito) {
            this.credito = credito;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="insertarSupervisorResponse", WrapperNamespace="http://services.creditomovil.pucp.edu.pe/", IsWrapped=true)]
    public partial class insertarSupervisorResponse {
        
        public insertarSupervisorResponse() {
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface SupervisorWSChannel : CreditoMovilWA.SupervisorWebService.SupervisorWS, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class SupervisorWSClient : System.ServiceModel.ClientBase<CreditoMovilWA.SupervisorWebService.SupervisorWS>, CreditoMovilWA.SupervisorWebService.SupervisorWS {
        
        public SupervisorWSClient() {
        }
        
        public SupervisorWSClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public SupervisorWSClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public SupervisorWSClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public SupervisorWSClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse CreditoMovilWA.SupervisorWebService.SupervisorWS.obtenerSupervisorPorId(CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest request) {
            return base.Channel.obtenerSupervisorPorId(request);
        }
        
        public CreditoMovilWA.SupervisorWebService.supervisor obtenerSupervisorPorId(int idSupervisor) {
            CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest inValue = new CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest();
            inValue.idSupervisor = idSupervisor;
            CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse retVal = ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).obtenerSupervisorPorId(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse> CreditoMovilWA.SupervisorWebService.SupervisorWS.obtenerSupervisorPorIdAsync(CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest request) {
            return base.Channel.obtenerSupervisorPorIdAsync(request);
        }
        
        public System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdResponse> obtenerSupervisorPorIdAsync(int idSupervisor) {
            CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest inValue = new CreditoMovilWA.SupervisorWebService.obtenerSupervisorPorIdRequest();
            inValue.idSupervisor = idSupervisor;
            return ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).obtenerSupervisorPorIdAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse CreditoMovilWA.SupervisorWebService.SupervisorWS.modificarSupervisor(CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest request) {
            return base.Channel.modificarSupervisor(request);
        }
        
        public void modificarSupervisor(int idSupervisor, CreditoMovilWA.SupervisorWebService.supervisor supervisor) {
            CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest();
            inValue.idSupervisor = idSupervisor;
            inValue.supervisor = supervisor;
            CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse retVal = ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).modificarSupervisor(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse> CreditoMovilWA.SupervisorWebService.SupervisorWS.modificarSupervisorAsync(CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest request) {
            return base.Channel.modificarSupervisorAsync(request);
        }
        
        public System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.modificarSupervisorResponse> modificarSupervisorAsync(int idSupervisor, CreditoMovilWA.SupervisorWebService.supervisor supervisor) {
            CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.modificarSupervisorRequest();
            inValue.idSupervisor = idSupervisor;
            inValue.supervisor = supervisor;
            return ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).modificarSupervisorAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse CreditoMovilWA.SupervisorWebService.SupervisorWS.eliminarSupervisor(CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest request) {
            return base.Channel.eliminarSupervisor(request);
        }
        
        public void eliminarSupervisor(int idSupervisor) {
            CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest();
            inValue.idSupervisor = idSupervisor;
            CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse retVal = ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).eliminarSupervisor(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse> CreditoMovilWA.SupervisorWebService.SupervisorWS.eliminarSupervisorAsync(CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest request) {
            return base.Channel.eliminarSupervisorAsync(request);
        }
        
        public System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.eliminarSupervisorResponse> eliminarSupervisorAsync(int idSupervisor) {
            CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.eliminarSupervisorRequest();
            inValue.idSupervisor = idSupervisor;
            return ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).eliminarSupervisorAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        CreditoMovilWA.SupervisorWebService.listarSupervisorResponse CreditoMovilWA.SupervisorWebService.SupervisorWS.listarSupervisor(CreditoMovilWA.SupervisorWebService.listarSupervisorRequest request) {
            return base.Channel.listarSupervisor(request);
        }
        
        public CreditoMovilWA.SupervisorWebService.supervisor[] listarSupervisor() {
            CreditoMovilWA.SupervisorWebService.listarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.listarSupervisorRequest();
            CreditoMovilWA.SupervisorWebService.listarSupervisorResponse retVal = ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).listarSupervisor(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.listarSupervisorResponse> CreditoMovilWA.SupervisorWebService.SupervisorWS.listarSupervisorAsync(CreditoMovilWA.SupervisorWebService.listarSupervisorRequest request) {
            return base.Channel.listarSupervisorAsync(request);
        }
        
        public System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.listarSupervisorResponse> listarSupervisorAsync() {
            CreditoMovilWA.SupervisorWebService.listarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.listarSupervisorRequest();
            return ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).listarSupervisorAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse CreditoMovilWA.SupervisorWebService.SupervisorWS.insertarSupervisor(CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest request) {
            return base.Channel.insertarSupervisor(request);
        }
        
        public void insertarSupervisor(CreditoMovilWA.SupervisorWebService.supervisor credito) {
            CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest();
            inValue.credito = credito;
            CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse retVal = ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).insertarSupervisor(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse> CreditoMovilWA.SupervisorWebService.SupervisorWS.insertarSupervisorAsync(CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest request) {
            return base.Channel.insertarSupervisorAsync(request);
        }
        
        public System.Threading.Tasks.Task<CreditoMovilWA.SupervisorWebService.insertarSupervisorResponse> insertarSupervisorAsync(CreditoMovilWA.SupervisorWebService.supervisor credito) {
            CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest inValue = new CreditoMovilWA.SupervisorWebService.insertarSupervisorRequest();
            inValue.credito = credito;
            return ((CreditoMovilWA.SupervisorWebService.SupervisorWS)(this)).insertarSupervisorAsync(inValue);
        }
    }
}