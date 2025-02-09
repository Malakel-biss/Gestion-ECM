import { Routes, Route, Navigate,useLocation } from "react-router-dom";
import { Dashboard, Auth,Dashboardprof ,Dashboardetudiant} from "@/layouts";
import { Homepage} from "@/pages/Acceuil";
import { Navbarhomepage } from "@/widgets/layout";
import routesnav from "@/routesnav";
function App() {
  const { pathname } = useLocation();
  return (
    <>
      {(pathname == '/Acceuil' ) && (
        <div className="container absolute left-2/4 z-10 mx-auto -translate-x-2/4 p-4">
          <Navbarhomepage routesnav={routesnav} />
        </div>
      )
      }
      
  
    <Routes>
      <Route path="/dashboard/*" element={<Dashboard />} />
      <Route path="/dashboardprof/*" element={<Dashboardprof />} />
      <Route path="/dashboardetudiant/*" element={<Dashboardetudiant />} />
      <Route path="/auth/*" element={<Auth />} />
      <Route path="/Acceuil/*" element={<Homepage />} />
      <Route path="*" element={<Navigate to="/Acceuil" replace />} />
       {routesnav.map(
          ({ path, element }, key) =>
            element && <Route key={key} exact path={path} element={element} />
        )}
    </Routes>
    </>
  );
}

export default App;
