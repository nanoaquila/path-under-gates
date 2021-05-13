package cyberslas.pathundergates;

import cyberslas.pathundergates.proxy.CommonProxy;
import cyberslas.pathundergates.util.MappedBlocklists;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PathUnderGates.MODID, name = PathUnderGates.NAME, version = PathUnderGates.VERSION, acceptableRemoteVersions="*")
public class PathUnderGates {
    public static final String MODID = "@modid@";
    public static final String NAME = "@modname@";
    public static final String VERSION = "@version@";

    @SidedProxy(clientSide = "cyberslas.pathundergates.proxy.ClientProxy", serverSide = "cyberslas.pathundergates.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static PathUnderGates instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();

        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        MappedBlocklists.processListsIntoMaps();
    }
}
